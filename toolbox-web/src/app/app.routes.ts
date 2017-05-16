import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";

export const routes: Routes = [
    {path: 'dashboard', redirectTo: '/dashboard', pathMatch: 'full'},
    {path: 'generator', redirectTo: '/generator', pathMatch: 'full'},
    {path: 'organisation-switcher', redirectTo: '/organisation-switcher', pathMatch: 'full'}

];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
