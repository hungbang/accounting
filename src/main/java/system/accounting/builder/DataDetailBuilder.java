package system.accounting.builder;

import system.accounting.model.DataDetail;

/**
 * Created by KAI on 4/18/18.
 */
public final class DataDetailBuilder {
    private String id;
    private String url;
    private String imageUrl;
    private String name;
    private String coinName;
    private String fullName;
    private String algorithm;
    private String proofType;
    private String sortOrder;

    private DataDetailBuilder() {
    }

    public static DataDetailBuilder aDataDetail() {
        return new DataDetailBuilder();
    }

    public DataDetailBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public DataDetailBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public DataDetailBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public DataDetailBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DataDetailBuilder withCoinName(String coinName) {
        this.coinName = coinName;
        return this;
    }

    public DataDetailBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public DataDetailBuilder withAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public DataDetailBuilder withProofType(String proofType) {
        this.proofType = proofType;
        return this;
    }

    public DataDetailBuilder withSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public DataDetail build() {
        DataDetail dataDetail = new DataDetail();
        dataDetail.setId(id);
        dataDetail.setUrl(url);
        dataDetail.setImageUrl(imageUrl);
        dataDetail.setName(name);
        dataDetail.setCoinName(coinName);
        dataDetail.setFullName(fullName);
        dataDetail.setAlgorithm(algorithm);
        dataDetail.setProofType(proofType);
        dataDetail.setSortOrder(sortOrder);
        return dataDetail;
    }
}
