
        <div class="form-box" id="login-box" ng-controller="UserLoginController as userLoginCtrl">
            <div class="header">Login</div>
            
	        <div class="alert alert-danger alert-dismissable" ng-show="userLoginCtrl.messageLogin != null">
	            <i class="fa fa-ban"></i>
	            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	            {{userLoginCtrl.messageLogin}}
	        </div>
	        
            <form ng-submit="userLoginCtrl.login(userLoginCtrl.user)" >
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" name="email" ng-model="userLoginCtrl.user.email" class="form-control" placeholder="Email"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" ng-model="userLoginCtrl.user.password" class="form-control" placeholder="Senha"/>
                    </div>          
                    <div class="form-group"> 
                        <input type="checkbox" name="remember_me"/> Lembrar
                    </div>
                </div>
                <div class="footer">                                                               
                    <button type="submit" class="btn bg-olive btn-block">Entrar</button>  
                    
                    <p><a href="#/usuario/esqueci_a_senha">Esqueci a senha</a></p>
                    
                    <a href="#/usuario/cadastro" class="text-center">Criar nova conta</a>
                </div>
            </form>
        </div>
