package miniShop.repository;

import miniShop.model.BaseModel;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StoredInStockImpl<T extends BaseModel<ID>,ID> implements Store<T, ID> {

    private final Map<ID, T> stockList;

    @SafeVarargs
    public StoredInStockImpl(T ... models) {
        this.stockList = Arrays.stream(models).collect(Collectors.toMap(k->k.getId(),v->v));
    }

    @Override
    public Optional<T> getById(ID id) {

        return stockList.containsKey(id) ? Optional.of(stockList.get(id)) : Optional.empty();
    }
}
