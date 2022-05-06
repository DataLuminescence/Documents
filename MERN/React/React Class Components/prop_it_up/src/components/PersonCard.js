import React, {Component} from 'react';


class PersonCard extends Component{
    render(){
        return(
            <div>
                <h1>{this.props.lastName}, {this.props.firstName}</h1>
                <h1>Age: {this.props.age}</h1>
                <h1>Hair Color: {this.props.hairColor}</h1>
            </div>
        );
    }
}

export default PersonCard;

