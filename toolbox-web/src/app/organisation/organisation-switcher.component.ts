import {Component, OnInit, trigger, state, transition, style, animate} from "@angular/core";

@Component({
    selector: 'organisation-switcher',
    templateUrl: './organisation-switcher.component.html',
    animations: [
        trigger('menu', [
            state('hidden', style({
                height: '0px'
            })),
            state('visible', style({
                height: '*'
            })),
            transition('visible => hidden', animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')),
            transition('hidden => visible', animate('400ms cubic-bezier(0.86, 0, 0.07, 1)'))
        ])
    ]
})
export class OrganisationSwitcherComponent implements OnInit {

    active: boolean;
    imageUrl: String;

    constructor() {
        this.imageUrl = "url('/assets/layout/images/building-icon.png')";
    }

    ngOnInit() {
    }

    onClick(event) {
        this.active = !this.active;
        event.preventDefault();
    }
}
