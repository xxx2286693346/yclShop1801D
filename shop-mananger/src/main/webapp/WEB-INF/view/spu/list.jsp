<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="container-fluid">
	<!--查询条件  -->
	<div>
	<form id="form1">
		<fieldset>
			<label for="key">关键字</label>
			<input id="key" name="key" value="${spuvo.key}">	
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="brand">品牌</label>
			<select id="brand" name="brandId">
			<option value="0">---请选择---</option>
				<c:forEach items="${brands}" var="brand">
					<option value="${brand.id}">${brand.name}</option>
				</c:forEach>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="orderColumn">排序字段</label>
			<select id="orderColumn" name="orderColumn">
				<option value="">---请选择---</option>
				<option value="goods_name" ${spuvo.orderColumn=='goodsName'?'selected':''}>名称</option>
				<option value="caption" ${spuvo.orderColumn=='caption'?'selected':''}>标题</option>
				<option value="category_id" ${spuvo.orderColumn=='category_id'?'selected':''}>分类</option>
				<option value="brand_id" ${spuvo.orderColumn=='brand_id'?'selected':''}>品牌</option>
			</select>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="orderType">排序方式</label>
			<input type="radio" name="orderType" value="ASC" ${spuvo.orderType=='ASC'?'checked':''}>升序&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name=orderType value="DESC" ${spuvo.orderType=='DESC'?'checked':''}>降序
			<input type="button" class="btn btn-info btn-sm" value="查询" onclick="query(1)">
			<button type="button" class="btn btn-warning btn-sm" onclick="toAdd()">添加</button>
		</fieldset>
		</form>
	</div>
	
	<!--查询结果 -->
	<div>
		<table class="table">
			<tr>
				<th>id <input type="checkbox"></th>
				<th>名称</th>
				<th>在售</th>
				<th>品牌</th>
				<th>标题</th>
				<th>分类</th>
				<th>图片</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${info.list}" var="spu">
				<tr>
				<td>${spu.id}</td>
				<td>${spu.goodsName}</td>
				<td>${spu.isMarketable=='0'?'下架':'在售'}</td>
				<td>${spu.brand.name}</td>
				<td>${spu.caption}</td>
				<td>${spu.category.name}</td>
				<td><img src="/pic/${spu.smallPic}" width="40" height="40"></td>
				<td>
					<input type="button" class="btn btn-danger btn-sm" value="删除" onclick="del(${spu.id})">
					<input type="button" class="btn btn-warning btn-sm" value="修改" onclick="toUpdate(${spu.id})">
					<input type="button" class="btn btn-info btn-sm" value="添加SKU" onclick="toAddSku(${spu.id})">
				</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	 <div>
	 	<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item"><a class="page-link" href="#">首页</a></li>
		    <c:forEach begin="1" end="${info.pages}" var="page">
		   	 	<li class="page-item"><a class="page-link" href="javascript:void(0)" onclick="query(${page})">${page}</a></li>
		    </c:forEach>
		    <li class="page-item"><a class="page-link" href="#">尾页</a></li>
		  </ul>
		</nav>
	 </div>
	
</div>
<script type="text/javascript">

//跳转到添加页面
function toAdd(){
	$("#workContent").load('./spu/toadd');
}


//删除
function del(id){
	
	if(!confirm('确认删除么？'))
		return;
	
	var ids=new Array();
	ids.push(id);
	$.post('./spu/del',{ids:ids},function(data){
		if(data=='ok'){
			alert('删除成功')
			//刷新
			query("${info.pageNum}")
		}else{
			alert('删除失败')
		}
		
	})
}


	//去修改
	function toUpdate(id){
		$("#workContent").load('./spu/toUpdate',{id:id});
	}


	//分页
	function query(page){
		var query= $("#form1").serialize();
		$("#workContent").load('./spu/list?pageNum='+page,query);
	}
	
	//添加sku
	function toAddSku(spuid){
		$("#workContent").load('./sku/toAdd',{spuId:spuid});
	}
</script>