/**
 * Created by Administrator on 2017/6/12.
 */
"use strict";

document.querySelector(".start").addEventListener("click",function () {
    console.log(document.querySelector(".line").style.width);
    console.log(window.pageXOffset);
    if(process==100){
        process=99;
        document.querySelector(".line").style["animationPlayState"]="running";
        infomation ();
    }else{

    }
});
var timer=null;
var process=1;
timer=setInterval(function () {
    document.querySelector(".start").innerHTML=process++ +"%";
    if(process==100){
        document.querySelector(".start").innerHTML="start";
        clearInterval(timer);
    }
    if(process==100){
       document.querySelector(".line").style["animationPlayState"]="paused";
    }
},110);
//获取可视化距离
function ke(){
    if(window.innerHeight!=null){
        return{
            width: window.innerWidth,
            height: window.innerHeight
        }
    }else if(document.compatMode=="CSS1Compat"){
        return{
            width: document.documentElement.clientWidth,
            height: document.documentElement.clientHeight
        }
    }else {
        return{
            width: document.body.clientWidth,
            height: document.body.clientHeight
        }
    }
}

//获取元素的指定属性
function getstyle(obj,attr) {
    if(obj.currentStyle){
        return parseInt(obj.currentStyle[attr]);
    }else{
        return parseInt(window.getComputedStyle(obj,null)[attr]);
    }
}

//背景生成
function code() {
    //设备宽度
    var s = window.screen;
    console.log(s.width);
    var width = hack.width = s.width;
    var height = hack.height = s.height;
    var yPositions = Array(300).join(0).split('');
    var ctx = hack.getContext('2d');
    var draw = function() {
        ctx.fillStyle = 'rgba(0,0,0,.05)';
        ctx.fillRect(0, 0, width, height);
        ctx.fillStyle = 'red ';/*代码颜色*/
        ctx.font = '10pt Georgia';
        yPositions.map(function(y, index) {
            var text = String.fromCharCode(1e2 + Math.random() * 330);
            var x = (index * 10) + 10;
            hack.getContext('2d').fillText(text, x, y);
            if (y > Math.random() * 1e4) {
                yPositions[index] = 0;
            } else {
                yPositions[index] = y + 10;
            }
        });
    };
    RunMatrix();
    function RunMatrix() {
        var Game_Interval = setInterval(draw,30);
    }
}
code();
var lis=document.querySelectorAll(".info li");
var  ul=document.querySelector(".info");
var i=0;
function infomation () {

    var timer=setInterval(function () {
        if(i<lis.length){
            ul.style["top"]=getstyle(ul,"top")-35+"px";
            console.log(getstyle(ul,"top"));
            lis[i++].style["display"]="block";
        }else {
            clearInterval(timer);
            document.querySelector(".start").style["borderColor"]="#2187e7";
            document.querySelector(".start").addEventListener("click",function () {
                window.location.href="cherry.html";
            })
        }
    },1000);
}