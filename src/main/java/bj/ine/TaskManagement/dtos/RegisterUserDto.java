package bj.ine.TaskManagement.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {
    @NotBlank(message = "Le nom de l'utilisateur ne peut pas être vide")
    private String name;

    @NotBlank(message = "L'adresse email de l'utilisateur ne peut pas être vide")
    @Email(message = "Veuillez entrer une adresse email valide")
    private String email;

    @NotBlank(message = "Le numero de telephone ne peut pas être vide")
    private String phoneNumber;
}
