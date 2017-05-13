import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {BrowserModule} from "@angular/platform-browser";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {LocationStrategy, HashLocationStrategy} from "@angular/common";
import {AppRoutes} from "./app.routes";
import "rxjs/add/operator/toPromise";
import {
    AccordionModule,
    AutoCompleteModule,
    BreadcrumbModule,
    ButtonModule,
    CalendarModule,
    CarouselModule,
    ChartModule,
    CheckboxModule,
    ChipsModule,
    CodeHighlighterModule,
    ConfirmDialogModule,
    SharedModule,
    ContextMenuModule,
    DataGridModule,
    DataListModule,
    DataScrollerModule,
    DataTableModule,
    DialogModule,
    DragDropModule,
    DropdownModule,
    EditorModule,
    FieldsetModule,
    FileUploadModule,
    GalleriaModule,
    GMapModule,
    GrowlModule,
    InputMaskModule,
    InputSwitchModule,
    InputTextModule,
    InputTextareaModule,
    LightboxModule,
    ListboxModule,
    MegaMenuModule,
    MenuModule,
    MenubarModule,
    MessagesModule,
    MultiSelectModule,
    OrderListModule,
    OverlayPanelModule,
    PaginatorModule,
    PanelModule,
    PanelMenuModule,
    PasswordModule,
    PickListModule,
    ProgressBarModule,
    RadioButtonModule,
    RatingModule,
    ScheduleModule,
    SelectButtonModule,
    SlideMenuModule,
    SliderModule,
    SpinnerModule,
    SplitButtonModule,
    StepsModule,
    TabMenuModule,
    TabViewModule,
    TerminalModule,
    TieredMenuModule,
    ToggleButtonModule,
    ToolbarModule,
    TooltipModule,
    TreeModule,
    TreeTableModule
} from "primeng/primeng";
import {AppComponent} from "./app.component";
import {AppMenuComponent, AppSubMenu} from "./app.menu.component";
import {AppTopBar} from "./app.topbar.component";
import {AppFooter} from "./app.footer.component";
import {InlineProfileComponent} from "./app.profile.component";
import {DashboardDemo} from "./demo/view/dashboarddemo";
import {SampleDemo} from "./demo/view/sampledemo";
import {FormsDemo} from "./demo/view/formsdemo";
import {DataDemo} from "./demo/view/datademo";
import {PanelsDemo} from "./demo/view/panelsdemo";
import {OverlaysDemo} from "./demo/view/overlaysdemo";
import {MenusDemo} from "./demo/view/menusdemo";
import {MessagesDemo} from "./demo/view/messagesdemo";
import {MiscDemo} from "./demo/view/miscdemo";
import {EmptyDemo} from "./demo/view/emptydemo";
import {ChartsDemo} from "./demo/view/chartsdemo";
import {FileDemo} from "./demo/view/filedemo";
import {UtilsDemo} from "./demo/view/utilsdemo";
import {Documentation} from "./demo/view/documentation";
import {CarService} from "./demo/service/carservice";
import {CountryService} from "./demo/service/countryservice";
import {EventService} from "./demo/service/eventservice";
import {NodeService} from "./demo/service/nodeservice";
import {DashboardModule} from "./dashboard/dashboard.module";
import {GeneratorModule} from "./generator/generator.module";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        AppRoutes,
        HttpModule,
        BrowserAnimationsModule,
        AccordionModule,
        AutoCompleteModule,
        BreadcrumbModule,
        ButtonModule,
        CalendarModule,
        CarouselModule,
        ChartModule,
        CheckboxModule,
        ChipsModule,
        CodeHighlighterModule,
        ConfirmDialogModule,
        SharedModule,
        ContextMenuModule,
        DataGridModule,
        DataListModule,
        DataScrollerModule,
        DataTableModule,
        DialogModule,
        DragDropModule,
        DropdownModule,
        EditorModule,
        FieldsetModule,
        FileUploadModule,
        GalleriaModule,
        GMapModule,
        GrowlModule,
        InputMaskModule,
        InputSwitchModule,
        InputTextModule,
        InputTextareaModule,
        LightboxModule,
        ListboxModule,
        MegaMenuModule,
        MenuModule,
        MenubarModule,
        MessagesModule,
        MultiSelectModule,
        OrderListModule,
        OverlayPanelModule,
        PaginatorModule,
        PanelModule,
        PanelMenuModule,
        PasswordModule,
        PickListModule,
        ProgressBarModule,
        RadioButtonModule,
        RatingModule,
        ScheduleModule,
        SelectButtonModule,
        SlideMenuModule,
        SliderModule,
        SpinnerModule,
        SplitButtonModule,
        StepsModule,
        TabMenuModule,
        TabViewModule,
        TerminalModule,
        TieredMenuModule,
        ToggleButtonModule,
        ToolbarModule,
        TooltipModule,
        TreeModule,
        TreeTableModule,
        DashboardModule,
        GeneratorModule
    ],
    declarations: [
        AppComponent,
        AppMenuComponent,
        AppSubMenu,
        AppTopBar,
        AppFooter,
        InlineProfileComponent,
        DashboardDemo,
        SampleDemo,
        FormsDemo,
        DataDemo,
        PanelsDemo,
        OverlaysDemo,
        MenusDemo,
        MessagesDemo,
        MessagesDemo,
        MiscDemo,
        ChartsDemo,
        EmptyDemo,
        FileDemo,
        UtilsDemo,
        Documentation
    ],
    providers: [
        {provide: LocationStrategy, useClass: HashLocationStrategy},
        CarService, CountryService, EventService, NodeService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
