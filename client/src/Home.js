import React, {Component} from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import {Link} from 'react-router-dom';
import {Button, Container} from 'reactstrap';
import {withCookies} from 'react-cookie';

class Home extends Component {
    state = {
        isLoading: true,
        isAuthenticated: false,
        user: undefined
    };

    constructor(props) {
        super(props);
        const {cookies} = props;
    }

    async componentDidMount() {

        this.setState(({isAuthenticated: false}))

    }


    render() {
        const message =
            <h2>Welcome, to Jambo !</h2>


        const button =
            <div>
                <Button color="link"><Link to="/orders">Orders</Link></Button>
                <br/>
                <Button color="link"><Link to="/products">Products</Link></Button>
            </div>

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    {message}
                    {button}
                </Container>
            </div>
        );
    }
}

export default withCookies(Home);