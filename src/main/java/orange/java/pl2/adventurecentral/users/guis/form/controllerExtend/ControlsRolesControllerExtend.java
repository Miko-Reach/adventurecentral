package orange.java.pl2.adventurecentral.users.guis.form.controllerExtend;

import orange.java.pl2.adventurecentral.users.enums.RoleName;
import orange.java.pl2.adventurecentral.users.models.Role;
import orange.java.pl2.adventurecentral.users.services.UserService;

public class ControlsRolesControllerExtend extends FieldsControllerExtend {

    @FXML
    protected CheckBox rolesClientModuleCheckbox;

    @FXML
    protected CheckBox rolesAgentModuleCheckbox;

    @FXML
    protected CheckBox rolesTravelAgencyModuleCheckbox;

    @FXML
    protected CheckBox rolesAviationCompanyModuleCheckbox;

    @FXML
    protected CheckBox rolesAdminModuleCheckbox;

    protected ControlsRolesControllerExtend(){
        addOnInitializeWithSneakyThrow(()->{
            for (Role role : this.user.getRoles()) {
                if (role.getRoleName().equals(RoleName.CLIENT)){
                    this.rolesClientModuleCheckbox.setSelected(true);
                } else if (role.getRoleName().equals(RoleName.AGENT)){
                    this.rolesAgentModuleCheckbox.setSelected(true);
                } else if (role.getRoleName().equals(RoleName.TRAVEL_AGENCY)){
                    this.rolesTravelAgencyModuleCheckbox.setSelected(true);
                } else if (role.getRoleName().equals(RoleName.AVIATION_COMPANY)){
                    this.rolesAviationCompanyModuleCheckbox.setSelected(true);
                } else if (role.getRoleName().equals(RoleName.ADMIN)){
                    this.rolesAdminModuleCheckbox.setSelected(true);
                }

            }
            this.rolesClientModuleCheckbox.selectedProperty().addListener((args, oldVal, newVal)->{
                if (newVal){
                    UserService.addRole(this.user, RoleName.CLIENT);
                } else {
                    UserService.removeRole(this.user, RoleName.CLIENT);
                }
            });
            this.rolesAgentModuleCheckbox.selectedProperty().addListener((args, oldVal, newVal)->{
                if (newVal){
                    UserService.addRole(this.user, RoleName.AGENT);
                } else {
                    UserService.removeRole(this.user, RoleName.AGENT);
                }
            });
            this.rolesTravelAgencyModuleCheckbox.selectedProperty().addListener((args, oldVal, newVal)->{
                if (newVal){
                    UserService.addRole(this.user, RoleName.TRAVEL_AGENCY);
                } else {
                    UserService.removeRole(this.user, RoleName.TRAVEL_AGENCY);
                }
            });
            this.rolesAviationCompanyModuleCheckbox.selectedProperty().addListener((args, oldVal, newVal)->{
                if (newVal){
                    UserService.addRole(this.user, RoleName.AVIATION_COMPANY);
                } else {
                    UserService.removeRole(this.user, RoleName.AVIATION_COMPANY);
                }
            });
            this.rolesAdminModuleCheckbox.selectedProperty().addListener((args, oldVal, newVal)->{
                if (newVal){
                    UserService.addRole(this.user, RoleName.ADMIN);
                } else {
                    UserService.removeRole(this.user, RoleName.ADMIN);
                }
            });
        });
    }
}
