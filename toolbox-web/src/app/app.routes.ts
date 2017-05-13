import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";

export const routes: Routes = [
    {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
    {path: 'generator', redirectTo: 'generator', pathMatch: 'full'}

];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
