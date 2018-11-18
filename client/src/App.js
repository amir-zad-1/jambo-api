import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import OrderList from './OrderList';
import OrderShow from './OrderShow';

import { CookiesProvider } from 'react-cookie';

class App extends Component {
    render() {
        return (
            <CookiesProvider>
                <Router>
                    <Switch>
                        {<Route path='/' exact={true} component={Home}/>}
                        <Route path='/orders' exact={true} component={OrderList}/>
                        <Route path='/orders/:id' component={OrderShow}/>
                    </Switch>
                </Router>
            </CookiesProvider>
        )
    }
}

export default App;