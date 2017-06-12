/**
 * Created by Administrator on 2017/6/12.
 */
"use strict";
(function () {
    var lis=document.querySelectorAll(".text li");
    var ul=document.querySelector(".text");
    var mu=document.querySelector("#mu");
    var i=0;
    var timer=setInterval(function () {
        if(i<lis.length){
            ul.style["top"]=getstyle(ul,"top")-50+"px";
            lis[i++].style["display"]="block";
        }else {
            clearInterval(timer);
            var m=19;
            var last=lis[--i].children[0];
            timer=setInterval(function () {
                if(m>-1){
                    last.innerHTML="距离自爆还有: "+(m--)+"s"
                }else{
                    clearInterval(timer);
                    mu.pause();
                    ul.parentNode.style["display"]="none";
                    document.querySelector(".video").style["display"]="block";
                    document.querySelector("#video").play();
                }
            },1000);
            if(confirm("是否逃离??")){
                clearInterval(timer);
                ul.parentNode.style["display"]="none";
                document.querySelector(".myheart").style["display"]="block";
            }else {
               alert("你就是在找死= = 有脾气等倒计时为0啊");
            }
        }
    },1000)
    
})();

//获取属性函数
function getstyle(obj,attr) {
    if(obj.currentStyle){
        return parseInt(obj.currentStyle[attr]);
    }else {
        return parseInt(window.getComputedStyle(obj,null)[attr]);
    }
}
