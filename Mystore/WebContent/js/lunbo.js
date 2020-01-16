var imgli = document.getElementsByClassName("img-li");/* 对图片所在的li无序列表标签对象进行获取操作 */
/* 对图片当中进行图片切换的两个按钮对象进行获取操作 */
var next = document.getElementById("next");
var previous = document.getElementById("previous");
var img_index = 0;/* 设置一个索引变量,用于记录当前所显示的图片的索引号 */
/* 建立新旧两个指针变量对象用于分别记录当前所显示的图片对象和下一个将要进行显示的图片对象 */
var oldLi = imgli[0];/* 页面一开始所显示的图片为索引值为0的图片 */
var newLi;/* 声明一个新的标签对象列表 */
var img_timer;/* 用于对图片进行自动播放时的计时器进行唯一标示 */
var box = document.getElementById("box");/* 获取整个盒子对象 */

/* 对图片下方的四个小圆点按钮对象进行获取操作 */
var one = document.getElementById("one");
var two = document.getElementById("two");
var three = document.getElementById("three");
var four = document.getElementById("four");
/* next.onclick是指当点击next标签对象当中的元素时将会触发的事件函数 */
next.onclick = function nextClick() {
	img_index++;
	if (img_index == imgli.length)
		img_index = 0;
	oldLi.style.opacity = 0;
	newLi = imgli[img_index];
	newLi.style.opacity = 1;
	oldLi = newLi;
}
previous.onclick = function previousClick() {
	img_index--;
	if (img_index < 0)
		img_index = imgli.length - 1;
	oldLi.style.opacity = 0;
	newLi = imgli[img_index];
	newLi.style.opacity = 1;
	oldLi = newLi;
}

/* 建立一个播放函数来实现对imgli标签对象当中的图片的自动播放操作 */
function play() {/*
					 * setInterval() 方法重复调用一个函数或执行一个代码段，在每次调用之间具有固定的时间延迟。该方法会返回一
					 * 个唯一标示当前计时器方法的ID值
					 */
	timer = window.setInterval(function() {
		next.onclick()
	}, 5000)
}
play();

/* 用于停止图片的自动播放操作 */
function stop() {
	clearInterval(timer);/* 根据计时器的ID值来清除指定的计时器对象，使得当前的图片停止自动播放操作 */
}
box.onmouseover = stop;/*
						 * 当鼠标移动到盒子的上方的时候将会进行事件的触发然后调用stop函数来执行自动播放的 停止操作
						 */
box.onmouseout = play;/* 当鼠标移出盒子对象的时候将会重新的调用play方法来再次进行图片的轮播操作 */

/* 当鼠标点击第一个小圆点对象所在标签时，将会触发该方法，然后改变盒子当中对应图片的透明度 */
one.onclick = function oneClick() {
	oldLi.style.opacity = 0;
	newLi = imgli[0];
	newLi.style.opacity = 1;
	oldLi = newLi;
}
one.onmouseover = one.onclick;
/* 点击第二个小圆点时触发的方法 */
two.onclick = function twoClick() {
	oldLi.style.opacity = 0;
	newLi = imgli[1];
	newLi.style.opacity = 1;
	oldLi = newLi;
}
two.onmouseover = two.onclick;

/* 点击第三个小圆点触发方法来进行图片的显示 */
three.onclick = function threeClick() {
	oldLi.style.opacity = 0;
	newLi = imgli[2];
	newLi.style.opacity = 1;
	oldLi = newLi;
}
three.onmouseover = three.onclick;

/* 点击第四个小圆点来进行对应事件的触发操作 */
four.onclick = function fourClick() {
	oldLi.style.opacity = 0;
	newLi = imgli[3];
	newLi.style.opacity = 1;
	oldLi = newLi;
}
four.onmouseover = four.onclick;
