<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div>  
<div>
	<button type="button" class="ben btn-primary btn-sm" onclick="add()">添加</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="btn btn-primary btn-sm" onclick="delBatch()">批量删除</button>
</div>
	<table class="table">
		<tr>
			<td>id <input type="checkbox" id="ids" onclick="selAll($(this))"> <button onclick="selReverse()">反选</button> </td>
			<td>名称</td>
			<td>属性</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${info.list}" var="spec">
		<tr>
			<td>${spec.id} <input type="checkbox" value="${spec.id}" name="id"  onclick="selOne()"></td>
			<td>${spec.specName}</td>
			<td>
				<c:forEach items="${spec.options}" var="op" varStatus="i">
				<c:if test="${i.index!=0}">
					,
				</c:if>
					${op.optionName}
				</c:forEach>
			</td>
			<td>
				<button type="button" class="ben btn-primary btn-sm" onclick="toupdate(${spec.id})">修改</button>
				<button type="button" class="ben btn-danger btn-sm" onclick="del(${spec.id})">删除</button>
			</td>
		</tr>
		</c:forEach>
	</table>
</div> 
<script type="text/javascript">
	function add(){
		$("#workContent").load('./spec/toadd');
	}
	
	
	function del(id){
		var re = confirm("确认要删除该数据吗")
		if(!re){
			return ;
		}
		var delIds=new Array();
		delIds.push(id)
		$.post("./spec/del",{ids:delIds},function(flag){
			if(flag){
				alert("删除成功");
				$("#workContent").load('./spec/list');
			}else{
				alert("删除失败");
			}
		})
	}
	
	
	function toupdate(id){
		$("#workContent").load('./spec/toupdate',{id:id});
	}
	
	
	
	// 全选  全不选
	function selAll(chkAll){
		var checked = chkAll.prop("checked");
		$("[name=id]").each(function(){
			$(this).prop('checked',checked)
		})
		
	}
	
	
	
	//反选
	function selReverse(){
		$("[name=id]").each(function(){
			$(this).prop('checked',!$(this).prop('checked') )
		})
	}
	
	
	
	// 点击列表中的一个复选框的时候的处理
	function selOne(){
		
		console.log(" 总长度 " + $("[name=id]").length)
		console.log(" xuanhong 长度 " +  $("[name=id]:checked").length )
		var checked=  $("[name=id]").length ==  $("[name=id]:checked").length ;
		
		$("#ids").prop("checked",checked)
		
	}
	
	function delBatch(){
		if($("[name=id]:checked").length<1){
			alert('请至少选中一条数据')
			return;
		}
		
		// 确认是否删除
		var cf=confirm("您确认要删除这些数据么？")
		if(!cf){
			return;
		}
		
		//被删除的数据的id 数组
		var delIds=new Array();
		$("[name=id]:checked").each(function(){
			delIds.push($(this).val());
		})
		
		console.log("将要删除的数据是 " + delIds)
		//return;
		$.post('./spec/del',{ids:delIds},function(data){
			if(data){
				alert('删除成功')
				$("#workContent").load('./spec/list');
			}else{
				alert('删除失败')
			}
		})
		
	}
</script>