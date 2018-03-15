/**
 * 
 */

$(document).ready(function(){
	$(document).ready(function(){
		$("input#sm1").on("click",function(da){
			da.preventDefault();
			$.post("/spweb/REST/spit.json",{username:"hung",type:3,sex:"man",QQ:"6199",id:101},function(da,sta,xhr){
				alert(sta);
				var ta = $("<table></table>");
				$(ta).attr("id","usertab")
				$("#tb").append(ta);
				$("#f1").remove();
				$.each(da,function(k,v){
					var tr=$("<tr></tr>");
					tr.attr("id",k);
					var tdk=$("<td></td>");
					tdk.text(k);
					$(tr).append(tdk).append($("<td>"+v+"</td>"))
					$(ta).append(tr)
				})
			})
			})
		})
})