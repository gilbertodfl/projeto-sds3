
import Home from 'pages/Home';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Dashboard from './pages/Dashboard';

const Routes = () => {
    return (
        
        <BrowserRouter>
            <switch>
                <Route path="/" exact>
                    <Home />
                </Route>

                <Route path="/dashboard" >
                    <Dashboard />
                </Route>

            </switch>
        </BrowserRouter>

    );
}

export default Routes;
