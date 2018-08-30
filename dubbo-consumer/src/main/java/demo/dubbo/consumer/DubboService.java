package demo.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DubboService {

    private static final Logger log = LoggerFactory.getLogger(DubboService.class);

    private ApplicationConfig application;
    private RegistryConfig registry;
    private String url;
    private String group;
    private String version;


    public DubboService(String url, String group, String version){
        this.url = url;
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-demo-provider");

        //这里配置了dubbo的application信息*(demo只配置了name)*，因此demo没有额外的dubbo.xml配置文件
        RegistryConfig registryConfig = new RegistryConfig();
        if (url.startsWith("zookeeper://")){
            registryConfig.setAddress(this.url);
        }
        this.group = group;
        this.application = applicationConfig;
        this.registry = registryConfig;
        this.version = version;
    }


    public Object genericInvoke(String interfaceClass, String methodName, String[] invokeParamTypes, Object[] invokeParams) throws Exception {

        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(application);
        //reference.setFilter();
        if(StringUtils.isNotBlank(version)){
            reference.setVersion(version);
        }
        reference.setInterface(interfaceClass); // 接口名
        reference.setGeneric(true); // 声明为泛化接口
        if (url.startsWith("dubbo://")){
            //本地调试非全注册，所以不能用zk
            reference.setUrl(url);
        }else if(url.startsWith("zookeeper://")){
            reference.setRegistry(registry);
        }
        //TODO将超时时间改成20s,看到有不少超时，在性能优化没完成前，先设置20
        reference.setTimeout(20000);
        if (group.length() > 0){
            reference.setGroup(group);
        }

        /*ReferenceConfig实例很重，封装了与注册中心的 连接以及与提供者的连接，
        需要缓存，否则重复生成ReferenceConfig可能造成性能问题并且会有内存和连接泄漏。
        API方式编程时，容易忽略此问题。
        这里使用dubbo内置的简单缓存工具类进行缓存*/
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        if (null  == genericService)
        {
            log.info("无法从cache中获取genericService,清空缓存，重新获取" + reference.toString());
            cache.destroy(reference);
            genericService = cache.get(reference);
        }


        if (null == genericService){
            log.error("无法从cache中获取genericService" + reference.toString());
            genericService = reference.get();
        }
        //GenericService genericService = reference.get();
        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
        log.info("开始远程调用dubbo-----------------------------");
        return genericService.$invoke(methodName, invokeParamTypes, invokeParams);
    }






}
