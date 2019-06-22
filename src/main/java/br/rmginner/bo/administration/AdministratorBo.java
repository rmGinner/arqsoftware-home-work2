package br.rmginner.bo.administration;

import br.rmginner.exception.BusinessValidationException;

public class AdministratorBo {

    public static void validateIfCpfIsOfAnAdmin(boolean result) throws BusinessValidationException {
        if(!result){
            throw new BusinessValidationException("Você não é um administrador e por isso não poderá realizar esta operação.");
        }
    }
}
