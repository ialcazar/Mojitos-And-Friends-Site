$(document).ready(start);

function start(){
	initEvents();
	initEffects();
	
}
function initEvents(){
	$("#li-index").click(function(){
		$("section.body section").hide();
		$("#proximamente").slideDown();
		
		$("section.content header nav ul li").removeClass("selected");
		$("#li-index").addClass("selected");
	});
	$("#li-about").click(function(){
		$("section.body section").hide();
		$("#de-que-va-esto").fadeIn();
		
		$("section.content header nav ul li").removeClass("selected");
		$("#li-about").addClass("selected");
	});
}

function initEffects(){
	$("#proximamente").slideDown("slow");
}
function cargar() { 
	if (GBrowserIsCompatible()) { 
		var map2 = new GMap2(document.getElementById("map2")); 
		map2.setCenter(new GLatLng(37.4419, -122.1419), 13); 
	} 
}