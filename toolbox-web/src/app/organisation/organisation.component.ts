import {Component, OnInit} from "@angular/core";
import {MenuItem} from "primeng/components/common/api";

@Component({
    selector: 'organisation',
    templateUrl: './organisation.component.html'
})
export class OrganisationComponent implements OnInit {

    private menuItems: MenuItem[];

    constructor() {
    }

    ngOnInit() {
        this.menuItems = [
            {label: 'Spaces', icon: 'fa-bar-chart', routerLink: 'spaces'},
            {label: 'Services', icon: 'fa-calendar', routerLink: 'services'}
        ];
    }

}
