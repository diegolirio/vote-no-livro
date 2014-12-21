
        <div class="form-box" id="login-box">
            <div class="header">Login</div>
            <form ng-submit="login(user)" >
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" name="email" ng-model="user.email" class="form-control" placeholder="Email"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" ng-model="user.password" class="form-control" placeholder="Senha"/>
                    </div>          
                    <div class="form-group">
                        <input type="checkbox" name="remember_me"/> Lembrar
                    </div>
                </div>
                <div class="footer">                                                               
                    <button type="submit" class="btn bg-olive btn-block">Entrar</button>  
                    
                    <p><a href="#">Esqueci a senha</a></p>
                    
                    <a href="#/usuario/cadastro" class="text-center">Criar nova conta</a>
                </div>
            </form>
        </div>
