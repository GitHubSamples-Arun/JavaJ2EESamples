import { Component } from '@angular/core';

@Component({
  selector: 'pm-root',
  template:`
     <div><h1>{{pageTitle}}</h1>
     <body>
     <tr>
     <td><app-yen></app-yen></td>

     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     
     <td><app-usd></app-usd></td>
     </tr>
     </body>
     </div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  pageTitle = 'Currency converter';
}
