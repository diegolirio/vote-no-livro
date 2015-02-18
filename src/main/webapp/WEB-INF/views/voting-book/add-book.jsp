<aside ng-controller="VotingBookVotingAddBookController as votingBookVotingAddBookCtrl" class="right-side" >

	<h1 class="text-success">{{votingBookVotingAddBookCtrl.voting.description}}</h1>
	<h3 class="text-info">Livros adicionados </h3>
	
	<ul>
		<li ng-repeat="vb in votingBookVotingAddBookCtrl.votingBooks">
			<h4>
				{{vb.book.title}} 
				<a ng-href ng-click="votingBookVotingAddBookCtrl.remove(vb)" title="Retirar da lista de votos">
					<span class="glyphicon glyphicon-remove text-danger"></span>
				</a>
			</h4> 
		</li>
	</ul>
	
	<hr/>
	
	<h1 class="text-danger">Adicionar livros</h1>
	
	<input ng-change="votingBookVotingAddBookCtrl.searchBook(votingBookVotingAddBookCtrl.word)" ng-model="votingBookVotingAddBookCtrl.word" type="search" size="50" >
	
    <section class="content">  
           <div ng-repeat="b in votingBookVotingAddBookCtrl.books"> 
               <div class="col-lg-2 col-sm-2 col-md-3 col-xs-8">                  	   
                   <p><img src="{{b.imgUrl}}" class="img-thumbnail img-responsive" title="{{b.title}}" /></p>
		  		   <a href ng-click="votingBookVotingAddBookCtrl.addVotacaoLivro(votingBookVotingAddBookCtrl.voting, b)" class="btn btn-success btn-block"> 
		  				<i class="glyphicon glyphicon-ok"></i>  Adicionar
                   </a>
                   <br/>
               </div>
    		</div>
	</section>	
	
	
</aside>