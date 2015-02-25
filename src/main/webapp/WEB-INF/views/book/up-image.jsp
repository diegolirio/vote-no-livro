<div ng-controller="BookUpImageController as bookUpImgtrl" class="right-side">

	{{ bookUpImgtrl.book.title }} 
	
	<img ng-src="{{bookFormCtrl.book.imgUrl == null ? '${pageContext.request.contextPath}/static/core/img/sem-foto.jpg' : bookFormCtrl.book.imgUrl}}">

</div>