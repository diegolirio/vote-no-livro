
<aside ng-controller="VotingCadastreController as votingCadastreCtrl" class="right-side">

         <!-- Content Header (Page header) -->
       <section class="content-header">
             <h1>
                 Votação
                 <small> Nova</small>
             </h1>
       </section>

         <!-- Main content -->
       <section class="content">
			<h1>{{votingCadastreCtrl.title}}</h1>	
	   </section>
		 
	   <div class="container">
		 <form ng-submit="votingCadastreCtrl.save(votingCadastreCtrl.voting)" class="form-horizontal" >
	 		
	 		<div ng-show="votingCadastreCtrl.voting.id > 0" class="row">
				<div class="control-group col-md-2">
					<label class="control-label">ID:</label>
					<div class="controls" >
						<input type="text" ng-model="votingCadastreCtrl.voting.id" class="form-control" disabled />
					</div>
				</div>	 
			</div>
			<div class="row">
				<div class="control-group col-md-5">
					<label class="control-label">Descrição:</label>
					<div class="controls" >
						<input type="text" ng-model="votingCadastreCtrl.voting.description" class="form-control" required />
					</div>
				</div>	 
			</div>

			<!-- <input type="hidden" ng-model="votingCadastreCtrl.voting.userOwner" /> -->
		 
		 	<br/>
		 
			<div class="form-actions">
				<button type="submit" class="btn btn-success">Salvar</button>
				<a href="#/" class="btn btn-default">Voltar</a> 
				<a ng-show="votingCadastreCtrl.voting.id > 0" class="btn btn-info" href="#/votacao/votacao_livro/{{votingCadastreCtrl.voting.id}}/add/livro">Add Livro</a>
				
				<a class="btn btn-danger pull-right" ng-click="votingCadastreCtrl.del()" ng-show="true">Excluir Votação</a>  
			</div>
				 
		 </form>
	   </div>		 
		 

</aside>
