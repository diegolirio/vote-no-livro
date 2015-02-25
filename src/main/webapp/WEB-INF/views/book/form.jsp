
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
					<img ng-src="{{bookFormCtrl.book.imgUrl}}">
					<a href="#/livro/{{bookFormCtrl.book.id}}/upImagem" onclick="show_window(this.href); return false;" class="btn btn-default">{{bookFormCtrl.book.imgUrl == null ? 'Enviar' : 'Alterar'}} Imagem do Livro</a>
				</div>	 
			</div>	 		
	 		
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
			<div class="row">
				<div class="control-group col-md-2">
					<label class="control-label">Ano:</label>  
					<div class="controls" >
						<input type="number" ng-model="bookFormCtrl.book.year" class="form-control" required maxlength="4"/> 
					</div>
				</div>	 
			</div>	
			<div class="row">
				<div class="control-group col-md-5">
					<label class="control-label">Editora:</label>
					<div class="controls" >
						<select ng-model="bookFormCtrl.book.publisher" ng-options="p.name for p in bookFormCtrl.publishers" class="form-control" >
      						<option value="">Selecione a Editora...</option>
    					</select>
					</div>
				</div>	 
			</div>						
			<div class="row">
				<div class="control-group col-md-1">
					<label class="control-label">Edição:</label>
					<div class="controls" >
						<input type="number" ng-model="bookFormCtrl.book.edicao" class="form-control" required />
					</div>
				</div>	 
			</div>	
			
		 	<br/>
		 
			<div class="form-actions">
				<button type="submit" class="btn btn-success">Salvar</button>
				<a href="#/" class="btn btn-default">Voltar</a>
				<a ng-show="bookFormCtrl.book.id > 0" ng-click="bookFormCtrl.del(bookFormCtrl.book)" class="btn btn-danger pull-right" >Excluir Votação</a>  
			</div>
				 
		 </form>
	   </div>		 
		 

</aside>
