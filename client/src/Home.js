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
                <Button color="link"><Link className={"btn-primary btn-lg"} to="/orders">Orders</Link></Button>

                <Button color="link"><Link className={"btn-primary btn-lg"} to="/products">Products</Link></Button>
            </div>

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className={"row h-100 justify-content-center align-items-center"}>
                        <img
                            src="https://trello-attachments.s3.amazonaws.com/5ba912dca09a8d0cb6f52b2e/5bb66c81e7d56c343d5b0b6c/89d053030970723402230df2673d4a8d/proxy_form.png"
                            alt="Jambo API"/>
                    </div>
                    <div className={"row h-100 justify-content-center align-items-center"}>


                        {message}

                    </div>
                    <div className={"row  justify-content-center "}>
                        {button}
                    </div>

                </Container>
            </div>
        );
    }
}

export default withCookies(Home);