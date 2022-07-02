package jerry_codes.example.recova.Mapper;

import jerry_codes.example.recova.entity.BankAccount;
import org.springframework.beans.BeanUtils;

public class BankAccountMapper extends BaseMapper<BankAccount, BankAccount> {

    @Override
    public BankAccount convertToEntity(BankAccount dto, Object... args) {
        BankAccount entity = new BankAccount();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity, "user");
        }
        return entity;
    }

    @Override
    public BankAccount convertToDto(BankAccount entity, Object... args) {
        BankAccount dto = new BankAccount();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto, "user");
        }
        return dto;
    }
}

