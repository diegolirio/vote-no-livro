<div >

	<aside class="right-side" >

         <section class="content-header">
             <h1>
                 Usuário <small> Esqueci a senha </small>
             </h1>
             <ol class="breadcrumb">
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Usuário</a></li>
                 <li class="active"> ? </li>
             </ol>
         </section>
	
	   <div class="container">
		 <form ng-submit="recoverPassword(user)" class="form-horizontal" >

			<div class="row">
				<div class="control-group col-md-4">
					<label class="control-label">Email:</label>
					<div class="controls" >
						<input type="email" ng-model="user.email" class="form-control" required name="email"/>
					</div>
				</div>	 
			</div>			
		
		 	<br/>
		 
			<div class="form-actions">
				<button type="submit" class="btn btn-success">Confirmar</button>
			</div>
				 
		 </form>
	   </div>

	</aside>

</div>