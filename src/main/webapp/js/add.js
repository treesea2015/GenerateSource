/*!
 * jQuery JavaScript Library v1.6
 * http://jquery.com/
 *
 * Copyright 2011, John Resig
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://jquery.org/license
 *
 * Includes Sizzle.js
 * http://sizzlejs.com/
 * Copyright 2011, The Dojo Foundation
 * Released under the MIT, BSD, and GPL Licenses.
 *
 * Date: Mon May 2 13:50:00 2011 -0400
 */
//表单操作 treesea888@icloud.com
function toSubmit() {
	if(checkAll()){
		return;
	};
	var basePath=self.location.href;
	basePath = basePath.replace("GenerateCodes/inputPageInfo/welcome","");
	var packageStr_data = $("#packageStr").val();
	var importStr_data = $("#importStr").val();
	var className_data = $("#className").val();
	var extendsStr_data = $("#extendsStr").val();
	var author_data = $("#author").val();
	var description_data = $("#description").val();
	
	var eName = $('[name="eName"]');
	var annotation = $('[name="annotation"]');
	var locatorWay = $('[name="locatorWay"]');
	var value = $('[name="value"]');
	var actType = $('[name="actType"]');
	

	var eName_data = "";
	var annotation_data = "";
	var locatorWay_data = "";
	var value_data = "";
	var actType_data = "";
	
	for (var i = 0; i < eName.length; i++) {
	    // 如果i+1等于选项长度则取值后添加空字符串，否则为逗号
	   eName_data = eName_data +eName[i].value+ (((i + 1)== eName.length) ? '':',');
	   annotation_data = annotation_data +annotation[i].value+ (((i + 1)== annotation.length) ? '':',');
	   locatorWay_data = locatorWay_data +locatorWay[i].value+ (((i + 1)== locatorWay.length) ? '':',');
	   value_data = value_data +value[i].value+ (((i + 1)== value.length) ? '':',');
	   actType_data = actType_data +actType[i].value+ (((i + 1)== actType.length) ? '':',');
	}
	$.ajax({
	   type : 'post',
	   url: basePath+"/GenerateCodes/inputPageInfo/generate",
	   dataType:'text',
	   data : {
		       packageStr : packageStr_data, 
		       importStr : importStr_data, 
		       className : className_data, 
		       extendsStr : extendsStr_data, 
		       author : author_data,
		       description  : description_data,
	           eName :  eName_data,
	           annotation : annotation_data,
	           locatorWay : locatorWay_data,
	           value : value_data,
	           actType : actType_data
	           
	   },
	   success: function(info){
		   alert("ok");
		   window.location.href=basePath+"/codes/"+info;
		   }	
	});
}
function  checkAll(){
	var inputs = $("input[type='text']");
	var flag = false;
	inputs.each(function(){
	    if($(this).val().trim().length==0){
	    	return flag = true;
	    }
	});
	if(flag){
		alert("输入项为空！请根据提示修正");
		inputs.each(function(){
		    if($(this).val().trim().length==0){
		    	$(this).css("background","pink")
		    }else{
		    	$(this).css("background","transparent")
		    }
		});
	}
	return flag;
}

function AddStructureRow() 
{ 
//alert("enter");
var obj=document.getElementById("table"); 
//var tr= obj.rows.length; 
var length =obj.rows.length

//插入行 code form www.jb51 .net 
var tr =obj.insertRow(length); 
var trId="content"+length; 
tr.setAttribute("id",trId); 
var td_name = tr.insertCell(0); 
td_name.setAttribute("align","left"); 
//td0.setAttribute("colSpan","4"); 
td_name.innerHTML = "<input type='text' name='eName' id='eName"+tr.rowIndex+"' /> "; 
var td_annotation = tr.insertCell(1); 
td_annotation.setAttribute("align","left"); 
//td1.setAttribute("colSpan","3"); 
td_annotation.innerHTML = "<input type='text' name='annotation' id='annotation"+tr.rowIndex+"'/>"; 

var td_select = tr.insertCell(2); 
td_annotation.setAttribute("align","left"); 
//td1.setAttribute("colSpan","3"); 
td_select.innerHTML = "<select name ='locatorWay' id='locatorWay"+tr.rowIndex+"'><option>id</option><option>name</option><option>xpath</option><option>css</option></select>"; 

var td_value = tr.insertCell(3); 
td_value.setAttribute("align","left"); 
//td1.setAttribute("colSpan","3"); 
td_value.innerHTML = "<input type='text' name='value' size='50' id='value"+tr.rowIndex+"'/>"; 

var td_select = tr.insertCell(4); 
td_annotation.setAttribute("align","left"); 
//td1.setAttribute("colSpan","3"); 
td_select.innerHTML = "<select name ='actType' id='actType"+tr.rowIndex+"'><option>click</option><option>input</option><option>select</option></select>"; 

var td_select = tr.insertCell(5); 
td_annotation.setAttribute("align","left"); 
//td1.setAttribute("colSpan","3"); 
td_select.innerHTML = "<input id='btnDelRow' class='btn' type='button' value='-' onclick='DelStructureRow("+tr.rowIndex+")'/>"; 

} 

function DelStructureRow(rowIndex) 
{ 
	var obj=document.getElementById("table");
	obj.deleteRow(rowIndex); 

} 

 