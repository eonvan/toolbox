import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {OrganisationSwitcherComponent} from "./organisation-switcher.component";
import {OrganisationComponent} from "./organisation.component";
import {ServiceComponent} from "../service/service.component";
import {SpaceComponent} from "../space/space.component";

const routes: Routes = [
    {
        path: 'organisation-switcher',
        component: OrganisationSwitcherComponent
    },
    {
        path: 'organisation/:id',
        component: OrganisationComponent,
        children: [
            {path: 'spaces', component: SpaceComponent},
            {path: 'services', component: ServiceComponent}
        ]
    }];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class OrganisationRoutingModule {
}
