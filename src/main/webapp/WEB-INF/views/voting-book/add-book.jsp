<aside ng-controller="VotingBookVotingAddBookController as votingBookVotingAddBookCtrl" class="right-side" >

	<span class="label label-primary">Livros da Votação (adicionar/remover)</span> 
	
	<h1 class="text-success">{{votingBookVotingAddBookCtrl.voting.description}} <small class="label label-default" style="font-size:12px;">{{votingBookVotingAddBookCtrl.voting.status}}</small> </h1>
	<h3 class="text-info">Livros adicionados </h3>
	
	<ul>
		<li ng-repeat="vb in votingBookVotingAddBookCtrl.votingBooks">
			<h4>
				{{vb.book.title}} 
				<a ng-href ng-click="votingBookVotingAddBookCtrl.remove(vb)" ng-show="votingBookVotingAddBookCtrl.voting.status == 'PENDENTE'" title="Retirar da lista de votos">
					<span class="glyphicon glyphicon-remove text-danger"></span>
				</a>
			</h4> 
		</li>
	</ul>
	
	<a ng-href ng-click="votingBookVotingAddBookCtrl.concluir(votingBookVotingAddBookCtrl.voting)" ng-show="votingBookVotingAddBookCtrl.voting.status == 'PENDENTE'" class="btn btn-success">Concluir</a>
	
	<hr/>
	
	<h1 class="text-danger">Adicionar livros</h1>
	
	<input ng-change="votingBookVotingAddBookCtrl.searchBook(votingBookVotingAddBookCtrl.word)" ng-model="votingBookVotingAddBookCtrl.word" type="search" size="50" placeholder="Pesquisar">
	
    <section class="content">  
           <div ng-repeat="b in votingBookVotingAddBookCtrl.books"> 
               <div class="col-lg-2 col-sm-2 col-md-3 col-xs-8">                  	   
                   <p><img src="{{b.imgUrl}}" class="img-thumbnail img-responsive" title="{{b.title}}" /></p>
		  		   <a href ng-click="votingBookVotingAddBookCtrl.addVotacaoLivro(votingBookVotingAddBookCtrl.voting, b)" ng-show="votingBookVotingAddBookCtrl.voting.status == 'PENDENTE'" class="btn btn-success btn-block"> 
		  				<i class="glyphicon glyphicon-ok"></i>  Adicionar
                   </a>
                   <br/>
               </div>
    		</div>
	</section>	
	
	
</aside>