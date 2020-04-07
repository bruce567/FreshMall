/*$(function(){
	var winW = $(window).width();
	var htmlFontSize = winW / 768 * 100;
    htmlFontSize < 55 && (htmlFontSize = 55);
	$("html").css("font-size",htmlFontSize+'px');
	$(".bargain_tab a").click(function(){
		var t= $(this) ,t_index = t.index();
		t.addClass("cur").siblings().removeClass("cur");
		$(".my_why_c").find(".or_none").eq(t_index).show().siblings().hide();
	});
	$(".bargain_tab1 a").click(function(){
		var t= $(this) ,t_index = t.index();
		t.addClass("cur").siblings().removeClass("cur");
		$(".my_why_c1").find(".or_none").eq(t_index).show().siblings().hide();
	});
});*/

!function (e, t) {
    var n = t.documentElement,
        d = e.devicePixelRatio || 1;

    function i() {
        var e = n.clientWidth / 768 * 100;
        e < 44 && (e = 44);
        n.style.fontSize = e + "px"
    }

    if (function e() {
            t.body ? t.body.style.fontSize = "16px" : t.addEventListener("DOMContentLoaded", e)
        }(), i(), e.addEventListener("resize", i), e.addEventListener("pageshow", function (e) {
            e.persisted && i()
        }), d >= 2) {
        var o = t.createElement("body"),
            a = t.createElement("div");
        a.style.border = ".5px solid transparent", o.appendChild(a), n.appendChild(o), 1 === a.offsetHeight && n.classList.add("hairlines"), n.removeChild(o)
    }
}(window, document);