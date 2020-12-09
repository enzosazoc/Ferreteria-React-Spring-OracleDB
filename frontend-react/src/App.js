import React from 'react';
import { BrowserRouter as Router, Route, Link, Switch, NavLink } from 'react-router-dom'

import './App.css';

// Componentes
import Home from './pages/Home/Home';
import Empresa from './pages/Empresa/Empresa';

function App() {
  return (
    <div className="App">
      <Router>
        <nav className="navbar navbar-expand-lg navbar-dark sombra-2 bgc-5">
          <div className="container-xl">
            <Link className="navbar-brand" to="/">F</Link>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav">
                <li className="nav-item">
                  <NavLink className="nav-link" activeClassName="active" exact to="/">Home</NavLink>
                </li>
                <li className="nav-item">
                  <NavLink className="nav-link" activeClassName="active" to="/empresa/">Empresa</NavLink>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        
        <div className="container-xl pt-3 p-1">
          <Switch className="container">
            <Route exact path="/">
              <Home/>
            </Route>
            <Route path="/empresa">
              <Empresa/>
            </Route>
          </Switch>
        </div>
        
      </Router>
    </div>
  );
}

export default App;
