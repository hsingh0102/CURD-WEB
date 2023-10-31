import React, { Component } from 'react';
import EmployeeServices from '../Services/EmployeeServices';

class ListEmployeeComponent extends Component {
    constructor(props){
        super(props)

        this.state={
            employees:[]
        }
    }

    componentDidMount(){
        EmployeeServices.getEmployees().then((res)=>{
            this.setState({employees: res.data});
        });
    }
    render() {
        return (
            <div>
                <h2 className="text-center">Employee List</h2>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Employee Name </th>
                                <th>Employee Address</th>
                                <th>Employee Degination</th>
                                <th>Active</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.employees.map(
                                    employee=>
                                    <tr key={employee.id}>
                                        <td>{employee.name}</td>
                                        <td>{employee.address}</td>
                                        <td>{employee.degination}</td>
                                        <td>{employee.active}</td>
                                    </tr>
                                )
                            }
                        </tbody>

                    </table>
                </div>
            </div>
        );
    }
}

export default ListEmployeeComponent;