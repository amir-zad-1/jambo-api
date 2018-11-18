import React, {Component} from 'react';
import {Link, withRouter} from 'react-router-dom';
import {Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import AppNavbar from './AppNavbar';
import {instanceOf} from 'prop-types';
import {Cookies, withCookies} from 'react-cookie';

class ProductShow extends Component {
    static propTypes = {
        cookies: instanceOf(Cookies).isRequired
    };

    emptyItem = {
        name: '',
        address: '',
        city: '',
        stateOrProvince: '',
        country: '',
        postalCode: ''
    };

    constructor(props) {
        super(props);
        const {cookies} = props;
        this.state = {
            item: this.emptyItem,
            csrfToken: cookies.get('XSRF-TOKEN')
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            try {
                const group = await (await fetch(`/products/${this.props.match.params.id}`)).json();
                this.setState({item: group});
            } catch (error) {
                this.props.history.push('/');
            }
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item, csrfToken} = this.state;

        await fetch('/api/group', {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'X-XSRF-TOKEN': csrfToken,
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
            credentials: 'include'
        });
        this.props.history.push('/groups');
    }

    render() {
        const {item} = this.state;
        const title = <h2>Product # {item.id}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                <div class="row">
                    <div className={"col-md-6"}>
                        <img src={item.imageUrl} alt="Smiley face" class="img-fluid"/>
                    </div>

                    <div className={"col-md-6"}>
                        {title}
                        <br/>
                        <p>
                            {item.description}
                        </p>
                        <p>

                        </p>

                        <p>
                            {item.price}
                        </p>
                        <p>
                            {item.supplierUrl}
                        </p>
                    </div>
                </div>


            </Container>
        </div>
    }
}

export default withCookies(withRouter(ProductShow));