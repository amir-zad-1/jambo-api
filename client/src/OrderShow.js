import React, {Component} from 'react';
import {Link, withRouter} from 'react-router-dom';
import {Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import AppNavbar from './AppNavbar';
import {instanceOf} from 'prop-types';
import {Cookies, withCookies} from 'react-cookie';

class OrderShow extends Component {
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
                const group = await (await fetch(`/orders/${this.props.match.params.id}`)).json();
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
        const title = <h2>Order #{item.id}</h2>;
        console.log(item)
        var items = item.orderItems || []
        console.log(items)

        const orderItemsList = items.map(group => {
            return <tr key={group.id}>
                <td style={{whiteSpace: 'nowrap'}}>{group.id}</td>
                <td style={{whiteSpace: 'nowrap'}}>{group.productName}</td>
                <td style={{whiteSpace: 'nowrap'}}>{group.quantity}</td>
                <td style={{whiteSpace: 'nowrap'}}>${group.price.toFixed(2)}</td>
            </tr>
        });
        return <div>
            <AppNavbar/>
            <Container>
                <div className={"row"}>
                    {title}
                </div>
                <div className={"row"}>
                    {/*shipping address*/}
                    <div className={"col-md-4 order-md-2 mb-4"}>
                        <h4 className="d-flex justify-content-between align-items-center mb-3">
                            <span className="text-muted">Shipping Address</span>
                        </h4>

                        <ul className="list-group mb-3">
                            <li className="list-group-item d-flex justify-content-between lh-condensed">
                                <div>
                                    <h6 className="my-0">
                                        {item.address.addressLine1} {item.address.addressLine2}
                                        <br/>
                                        {item.address.city} {item.address.province} ({item.address.postalCode})
                                        <br/>
                                        {item.address.country}
                                    </h6>
                                </div>
                            </li>
                        </ul>

                    </div>

                    {/*order Details*/}
                    <div className={"col-md-8 order-md-1"}>
                        <div className={"row"}>
                            <div className={"col-md-6 mb-3"}>
                                <h4>Customer</h4>
                                <p>
                                    {item.customerName}
                                </p>
                            </div>
                            <div className={"col-md-6 mb-3"}>
                                <h4>Total</h4>
                                <p>
                                    ${(item.total || 0).toFixed(2)}
                                </p>
                            </div>

                        </div>
                        <div className={"row"}>
                            <div className={"col-md-6 mb-3"}>
                                <h4>Status</h4>
                                <p>
                                    {item.status}
                                </p>
                            </div>
                            <div className={"col-md-6 mb-3"}>
                                <h4>Date</h4>
                                <p>
                                    {item.date}
                                </p>
                            </div>
                        </div>


                        <div>
                            <h4>Description</h4>
                            <p>
                                {item.description}
                            </p>
                        </div>
                    </div>
                </div>

                <div className={"row"}>
                    <table className={"table "}>
                        <thead>
                        <tr>
                            <th scope={"col"}>
                                Id
                            </th>
                            <th scope={"col"}>
                                Product
                            </th>
                            <th scope={"col"}>
                                Quantity
                            </th>
                            <th scope={"col"}>
                                Price
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        {orderItemsList}
                        </tbody>
                    </table>
                </div>

            </Container>
        </div>
    }
}

export default withCookies(withRouter(OrderShow));