import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TestComponent } from './test/test.component';
import { RegisterComponentComponent } from './register-component/register-component.component';
import { LoginComponentComponent } from './login-component/login-component.component';
import { ReceiptGenerateComponent } from './receipt-generate/receipt-generate.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';

const routes: Routes = [
	{
		path:'main',
		component:TestComponent
	},
	{
		path:'register',
		component:RegisterComponentComponent
	},
	{
		path:'',
		component:LoginComponentComponent
	},
	{
		path:'receiptRegister',
		component:ReceiptGenerateComponent
	},
	{
		path:'viewEmployees',
		component:ViewEmployeeComponent
	},
	{
		path:'**',redirectTo:'',pathMatch:'full'
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [TestComponent,RegisterComponentComponent,LoginComponentComponent,ReceiptGenerateComponent,ViewEmployeeComponent];
