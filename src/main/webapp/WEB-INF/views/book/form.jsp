
<aside ng-controller="BookFormController as bookFormCtrl" class="right-side">

         <!-- Content Header (Page header) -->
       <section class="content-header">
             <h1>
                 Livro
                 <small>{{bookFormCtrl.book.title}}</small>
             </h1>
       </section>

         <!-- Main content -->
<!--        <section class="content"> -->
<!-- 			<h1>{{votingCadastreCtrl.title}}</h1>	 -->
<!-- 	   </section> -->
		 
	   <div class="container">
		 <form ng-submit="bookFormCtrl.save(bookFormCtrl.book)" class="form-horizontal" >
	 		
	 		<div ng-show="bookFormCtrl.book.id > 0" class="row">
				<div class="control-group col-md-2">
					<label class="control-label">ID:</label>
					<div class="controls" >
						<input type="text" ng-model="bookFormCtrl.book.id" class="form-control" disabled />
					</div>
				</div>	 
			</div>
			<div class="row">
				<div class="control-group col-md-5">
					<label class="control-label">Titulo:</label>
					<div class="controls" >
						<input type="text" ng-model="bookFormCtrl.book.title" class="form-control" required />
					</div>
				</div>	 
			</div>

		 	<br/>
		 
			<div class="form-actions">
				<button type="submit" class="btn btn-success">Salvar</button>
				<a href="#/" class="btn btn-default">Voltar</a> 
				<a ng-show="votingCadastreCtrl.voting.id > 0" class="btn btn-info" href="#/votacao_livro/votacao/{{votingCadastreCtrl.voting.id}}/add/livro">Add Livro</a>
				
				<a ng-show="votingCadastreCtrl.voting.id > 0" ng-click="votingCadastreCtrl.del(votingCadastreCtrl.voting)" class="btn btn-danger pull-right" >Excluir Votação</a>  
			</div>
				 
		 </form>
	   </div>		 
		 

</aside>
