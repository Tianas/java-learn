/**
 * Created by ting on 16/10/22.
 */

$(document).ready(function() {



    $("#submit").click(function (){ajaxAdd();});

})

function ajaxAdd(){
    $("#result").empty();
    $.ajax({
        method: "post",
        url: "/datatest/ajaxadd.json",
        data: {
            data1: $("#data1").val(),
            data2:$("#data2").val(),
        },
        dataType:"text",
        success: function (data) {
            var count = data;
            $("#result").append(count);
        }
    })
}



