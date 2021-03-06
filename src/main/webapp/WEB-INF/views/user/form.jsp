<div ng-init="loadUserCadastre()">

	<aside class="right-side" >

         <section class="content-header">
             <h1>
                 Usu�rio <small> Cadastro</small>
             </h1>
             <ol class="breadcrumb">
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Usu�rio</a></li>
                 <li class="active">Cadastro</li>
             </ol>
         </section>
	
	   <div class="container">
		 <form ng-submit="saveUser(user, confirmPassword)" class="form-horizontal" >
	 		
	 		<div class="row">
				<div class="control-group col-md-2">
					<label class="control-label">ID:</label>
					<div class="controls" >
						<input type="text" ng-model="user.id" class="form-control" disabled />
					</div>
				</div>	 
			</div>
			<div class="row">
				<div class="control-group col-md-5">
					<label class="control-label">Nome completo:</label>
					<div class="controls" >
						<input type="text" ng-model="user.name" class="form-control" required />
					</div>
				</div>	 
			</div>
			<div class="row">
				<div class="control-group col-md-4">
					<label class="control-label">Email:</label>
					<div class="controls" >
						<input type="email" ng-model="user.email" class="form-control" required />
					</div>
				</div>	 
			</div>			
			<div class="row">
				<div class="control-group col-md-4">
					<label class="control-label">Nome que gostaria de ser chamado:</label>
					<div class="controls" >
						<input type="text" ng-model="user.nickname" class="form-control" required />
					</div>
				</div>	 
			</div>
			<div class="row">
				<div class="control-group col-md-3">
					<label class="control-label">Senha:</label>
					<div class="controls" >
						<input type="password" ng-model="user.password" class="form-control" required />
					</div>
				</div>	 
			</div>			
			<div class="row">
				<div class="control-group col-md-3">
					<label class="control-label">Confirmar senha:</label>
					<div class="controls" >
						<input type="password" ng-model="confirmPassword" class="form-control" required />
					</div>
				</div>	 			
		 	</div>
		 	<br/>
		 
			<div class="form-actions">
				<button type="submit" class="btn btn-success">Salvar</button>
				<a href="#/" class="btn btn-default">Voltar</a> 
				
				<a class="btn btn-danger pull-right" ng-click="del()" ng-show="false">Excluir</a>  
			</div>
				 
		 </form>
	   </div>

	</aside>

</div>