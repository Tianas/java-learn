<%--
  Created by IntelliJ IDEA.
  User: ting
  Date: 16/10/22
  Time: 下午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <script src="/static_resource/jquery/jquery-3.0.0.min.js" language="javascript" type="text/javascript"></script>
  <script src="/static_resource/js/datatest.js" language="JavaScript" type="text/javascript"></script>

      <title>数据测试</title>
</head>
<body>

<div class="container" style="padding-top: 50px;">

  <div class="row">
    <h2>ajax提交-加法</h2>
  </div>

  <div class="row ">
    <div class="form-inline">

      <div class="form-group">
        <label for="data1">输入1:</label>
        <input type="text" class="form-control" id="data1" name="data1" placeholder="">
      </div>
      <div class="form-group">
        <label for="data2">输入2:</label>
        <input type="text" class="form-control" id="data2" name="data2" placeholder="">
      </div>

      <button class="btn btn-primary active pull-right" type="submit" id="submit">提交</button>
    </div>

  </div>


  <div class="row">
    <h2>结果</h2>
  </div>
  <div class="row ">
    <p id="result"></p>
    </div>


</div>

</body>
</html>
