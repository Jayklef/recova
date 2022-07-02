package jerry_codes.example.recova.Mapper;

import jerry_codes.example.recova.entity.BankAccount;
import jerry_codes.example.recova.entity.Client;
import org.springframework.beans.BeanUtils;

import java.util.Set;
public class ClientMapper extends BaseMapper<Client, Client> {

    private BankAccountMapper bankAccountMapper = new BankAccountMapper();
    @Override
    public Client convertToEntity(Client dto, Object... args) {
        Client entity = new Client();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity, "accounts");
            entity.setAccounts((Set<BankAccount>) bankAccountMapper.convertToEntityList(dto.getAccounts()));
        }
        return entity;
    }

    @Override
    public Client convertToDto(Client entity, Object... args) {
        Client dto = new Client();
        if (entity != null){
            BeanUtils.copyProperties(entity, dto, "accounts");
            dto.setAccounts((Set<BankAccount>) bankAccountMapper.convertToDtoList(entity.getAccounts()));
        }
        return dto;
    }
}