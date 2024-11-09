//package com.zp.basic.product.biz.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.zp.basic.feign.user.client.UserFeignClient;
//import com.zp.basic.product.biz.ProductBiz;
//import com.zp.basic.product.dto.CartDto;
//import com.zp.basic.product.dto.CartItemDto;
//import com.zp.basic.product.dto.ProductStockDto;
//import com.zp.basic.product.engine.model.ProductIndex;
//import com.zp.basic.product.model.Product;
//import com.zp.basic.product.request.*;
//import com.zp.basic.product.service.ProductService;
//import com.zp.basic.product.vo.CartItemVo;
//import com.zp.basic.product.vo.CartVo;
//import com.zp.basic.product.vo.ProductVo;
//import com.zp.basic.warehouse.service.WarehouseService;
//import com.zp.util.general.enums.StatusEnum;
//import com.zp.util.general.exception.ZfException;
//import com.zp.util.general.response.CommonResponse;
//import com.zp.util.general.util.*;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.Assert;
//import redis.clients.jedis.Jedis;
//
//import java.math.BigDecimal;
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * @author zp
// * @create 2022/1/28 15:41
// * @desc 商品核心业务实现层
// **/
//@Service
//public class ProductBizImpl implements ProductBiz {
//    private ProductService productService;
//    private WarehouseService warehouseService;
//    private UserFeignClient userFeignClient;
//
//    public ProductBizImpl(ProductService productService, WarehouseService warehouseService, UserFeignClient userFeignClient) {
//        this.productService = productService;
//        this.warehouseService = warehouseService;
//        this.userFeignClient = userFeignClient;
//    }
//
//    @Override
//    public Map<String, Object> selectPageProduct(SelectPageProductRequest selectPageProductRequest) {
////        Page<ProductIndex> product = productIndexService.selectPageProduct(selectPageProductRequest);
////        List<ProductVo> productVos = BeanUtil.convertList(product.getContent(), ProductVo.class);
////        if (CollectionUtils.isNotEmpty(productVos)) {
////            //计算库存
////            this.handleStock(productVos);
////            //计算金额
////            this.handleMoney(productVos);
////            int totalElements = (int) product.getTotalElements();
////            return CommonResponse.setIndexPageResponse(productVos, totalElements);
////        }
//
//        return CommonResponse.setIndexPageResponse(null, null);
//    }
//
//    private void handleStock(List<ProductVo> productVos) {
//        //库存取出除1W
//        productVos.stream().forEach(productVo -> {
//            BigDecimal stock = MyBigDecimalUtil.divide(productVo.getStock());
//            productVo.setRealStock(stock);
//        });
//    }
//
//    private void handleMoney(List<ProductVo> productVos) {
//        //金额取出除1W
//        productVos.stream().forEach(productVo -> {
//            BigDecimal money = MyBigDecimalUtil.divide(productVo.getProductMoney());
//            productVo.setRealProductMoney(money);
//        });
//    }
//
//
//    @Override
//    @Transactional
//    public Map<String, Object> insertProduct(ProductSaveRequest productRequest) {
//        //判断商品编码是否重复
//        Product product = productService.findProductByCode(productRequest.getProductCode());
//        if (product != null) {
//            throw new ZfException("该商品编码已存在");
//        }
//        String uuid = UUID.randomUUID().toString();
//        if (StringUtils.isEmpty(productRequest.getProductUrl())) {
//            productRequest.setProductUrl(OssUtil.GLOBAL_IMG_URL);
//        }
//        //存入数据库
//        Product newProduct = this.saveProduct(productRequest, uuid);
//        this.saveProductToRedisAndEs(newProduct);
//        return CommonResponse.setResponseData(null);
//    }
//
//    @Override
//    @Transactional
//    public Map<String, Object> updateProduct(ProductUpdateRequest productUpdateRequest) {
//        //判断商品是否存在
//        Product product = productService.findProductById(productUpdateRequest.getProductId());
//        Assert.notNull(product, "该商品不存在");
//        //判断商品编码是否重复
//        if (!StringUtils.equals(product.getProductCode(), productUpdateRequest.getProductCode())) {
//            Product productByCode = productService.findProductByCode(productUpdateRequest.getProductCode());
//            if (productByCode != null) {
//                throw new ZfException("该商品编码已存在");
//            }
//        }
//        //更新数据库数据
//        Product newProduct = this.updateProductDb(product, productUpdateRequest);
//        //存入缓存以及es
//        this.saveProductToRedisAndEs(newProduct);
//        return CommonResponse.setResponseData(null);
//    }
//
//
//    @Override
//    @Transactional
//    public Map<String, Object> updateProductStatus(UpdateProductStatusRequest updateProductStatusRequest) {
//        Boolean flag = updateProductStatusRequest.getFlag();
//        //转换为数据库存储值
//        String flagValue = this.returnFlagValue(flag);
//        List<String> oldIdList = Arrays.asList(updateProductStatusRequest.getIds());
//        //查询id是否存在
//        List<Product> products = productService.selectProductByIds(oldIdList);
//        if (CollectionUtils.isNotEmpty(products)) {
//            List<String> newIdList = products.stream().map(product -> product.getProductId()).collect(Collectors.toList());
//            List<String> subtract = (List<String>) CollectionUtils.subtract(oldIdList, newIdList);
//            if (CollectionUtils.isNotEmpty(subtract)) {
//                throw new ZfException(subtract + "商品不存在");
//            }
//        } else {
//            throw new ZfException(oldIdList + "商品不存在");
//        }
//        //更新数据库数据
//        this.batchUpdateProductStatusDb(oldIdList, flagValue);
//        //批量存入缓存以及ES
//        this.saveBatchProductToRedisAndEs(products);
//        return CommonResponse.setResponseData(null);
//    }
//
//    @Override
//    public Map<String, Object> findProductById(String id) {
//        Product product = productService.findProductById(id);
//        Assert.notNull(product, id + ":该商品不存在");
//        return CommonResponse.setResponseData(product);
//    }
//
//    @Override
//    public Map<String, Object> selectPageProductShop(SelectPageProductRequest selectPageProductRequest) {
//        Page<ProductIndex> product = productIndexService.selectPageProductShop(selectPageProductRequest);
//        List<ProductVo> productVos = BeanUtil.convertList(product.getContent(), ProductVo.class);
//        if (CollectionUtils.isNotEmpty(productVos)) {
//            //计算库存
//            this.handleStock(productVos);
//            //计算金额
//            this.handleMoney(productVos);
//            int totalElements = (int) product.getTotalElements();
//            return CommonResponse.setIndexPageResponse(productVos, totalElements);
//        }
//        return CommonResponse.setIndexPageResponse(null, null);
//    }
//
//    @Override
//    @Transactional
//    public Map<String, Object> addCart(String productId) {
//        //判断该商品是否存在库存
//        List<String> list = new ArrayList<>();
//        list.add(productId);
//        List<ProductStockDto> productStockDtoList = warehouseService.selectStock(list);
//        if(CollectionUtils.isEmpty(productStockDtoList)){
//            throw new ZfException("该商品库存不足！");
//        }
//        if(productStockDtoList.get(0).getStock().compareTo(new BigDecimal("0"))!=1){
//            throw new ZfException("该商品库存不足！");
//        }
//        String userId = ContextUtils.getUserId();
//        Object userByUid = userFeignClient.findUserByUid(userId);
//        Assert.notNull(userByUid, "该用户不存在！");
//        //判断redis是否存在，存在则添加数量，不存在则数量为1
//        Jedis jedis = JedisUtil.getJedis();
//        String key = JedisUtil.buildKey(JedisUtil.CART_KEY, userId);
//        AddCartRequest addCartRequest = new AddCartRequest();
//        addCartRequest.setUserId(userId);
//        addCartRequest.setProductId(productId);
//        if (jedis.exists(key)) {
//            //处理购物车
//            this.handleCart(jedis, key, addCartRequest);
//        } else {
//            //创建购物车
//            this.buildCart(jedis, key, addCartRequest);
//        }
//        //关闭连接
//        jedis.close();
//        return CommonResponse.setResponseData(null);
//    }
//
//    @Override
//    public Map<String, Object> showCart(String productCodeOrName) {
//        String userId = ContextUtils.getUserId();
//        String key = JedisUtil.buildKey(JedisUtil.CART_KEY, userId);
//        Jedis jedis = JedisUtil.getJedis();
//        if (jedis.exists(key)) {
//            String str = jedis.get(key);
//            //构建cartVo
//            CartVo cartVo = this.buildCartVo(jedis, str);
//            //根据查询条件,加工VO
//            this.handleQuery(cartVo, productCodeOrName);
//            //关闭连接
//            jedis.close();
//            return CommonResponse.setResponseData(cartVo);
//        } else {
//            //关闭连接
//            jedis.close();
//            return CommonResponse.setResponseData(null);
//        }
//    }
//
//    private void handleQuery(CartVo cartVo, String productCodeOrName) {
//        if (StringUtils.isNotBlank(productCodeOrName)) {
//            List<CartItemVo> cartItemVos = cartVo.getCartItemVos();
//            List<CartItemVo> collect = cartItemVos.stream().filter(cartItemVo ->
//                    cartItemVo.getProductName().contains(productCodeOrName) || cartItemVo.getProductCode().contains(productCodeOrName))
//                    .collect(Collectors.toList());
//            cartVo.setCartItemVos(collect);
//        }
//    }
//
//    @Override
//    public void saveProductToEsAndRedis(Product product) {
//        //计算库存
//        this.handleProductStock(product);
//        //计算索引的库存和金额
//        ProductIndex productIndex = this.handleIndexProductStockAndMoney(product);
//        //更新缓存
//        String key = JedisUtil.buildKey(JedisUtil.PRODUCT_KEY, product.getProductId());
//        JedisUtil.getJedis().set(key, JSON.toJSONString(product));
//        //更新索引
//        productIndexService.saveProductIndex(productIndex);
//    }
//
//    @Override
//    public void saveTtlProductToEsAndRedis(String productId) {
//        Product productById = productService.findProductById(productId);
//        this.saveProductToEsAndRedis(productById);
//    }
//
//    @Override
//    public Map<String, Object> deleteCartItem(List<String> productIds) {
//        CartDto cartDto = new CartDto();
//        Jedis jedis = JedisUtil.getJedis();
//        String userId = ContextUtils.getUserId();
//        String key = JedisUtil.buildKey(JedisUtil.CART_KEY, userId);
//        if (jedis.exists(key)) {
//            //获取购物车
//            String json = jedis.get(key);
//            cartDto = JSON.parseObject(json, CartDto.class);
//            //删除购物车该商品购物项
//            List<CartItemDto> cartItemDtoList = cartDto.getCartItemDtoList();
//            if (CollectionUtils.isNotEmpty(cartItemDtoList)) {
//                List<CartItemDto> old_cartItemDtoList = cartItemDtoList.stream().filter(cartItemDto -> productIds.contains(cartItemDto.getProductId())).collect(Collectors.toList());
//                cartItemDtoList.removeAll(old_cartItemDtoList);
//                cartDto.setCartItemDtoList(cartItemDtoList);
//                String jsonString = JSON.toJSONString(cartDto);
//                jedis.set(key,jsonString);
//            }
//        }
//        //关闭连接
//        jedis.close();
//        return CommonResponse.setResponseData(cartDto);
//    }
//
//    @Override
//    public Map<String, Object> deleteAllCartItem() {
//        Jedis jedis = JedisUtil.getJedis();
//        String userId = ContextUtils.getUserId();
//        String key = JedisUtil.buildKey(JedisUtil.CART_KEY, userId);
//        if (jedis.exists(key)) {
//            Long del = jedis.del(key);
//            if (del != 1L) {
//                throw new ZfException("删除购物车失败");
//            }
//        }
//        //关闭连接
//        jedis.close();
//        return CommonResponse.setResponseData(null);
//    }
//
//    @Override
//    public Map<String, Object> changeCartItemNum(ChangeCartItemNumRequest changeCartItemNumRequest) {
//        Jedis jedis = JedisUtil.getJedis();
//        String userId = ContextUtils.getUserId();
//        String key = JedisUtil.buildKey(JedisUtil.CART_KEY, userId);
//        if (jedis.exists(key)) {
//            String json = jedis.get(key);
//            CartDto cartDto = JSON.parseObject(json, CartDto.class);
//            List<CartItemDto> cartItemDtoList = cartDto.getCartItemDtoList();
//            if(CollectionUtils.isNotEmpty(cartItemDtoList)){
//                cartItemDtoList.stream().forEach(cartItemVo -> {
//                    if (StringUtils.equals(cartItemVo.getProductId(), changeCartItemNumRequest.getProductId())) {
//                        cartItemVo.setNum(changeCartItemNumRequest.getNum());
//                    }
//                });
//                String jsonString = JSON.toJSONString(cartDto);
//                jedis.set(key, jsonString);
//            }
//        }
//        //关闭连接
//        jedis.close();
//        return CommonResponse.setResponseData(null);
//    }
//
//    private void saveBatchProductToRedisAndEs(List<Product> products) {
//        products.stream().forEach(product -> {
//            this.saveProductToRedisAndEs(product);
//        });
//    }
//
//
//    private CartVo buildCartVo(Jedis jedis, String str) {
//        CartVo cartVo = new CartVo();
//        List<CartItemVo> cartItemVos = new ArrayList<>();
//        CartDto cartDto = JSON.parseObject(str, CartDto.class);
//        List<CartItemDto> cartItemDtoList = cartDto.getCartItemDtoList();
//        cartItemDtoList.stream().forEach(cartItemDto -> {
//            String productId = cartItemDto.getProductId();
//            Integer num = cartItemDto.getNum();
//            //从缓存中取出商品详情
//            String json = jedis.get(JedisUtil.buildKey(JedisUtil.PRODUCT_KEY, productId));
//            Product product = JSON.parseObject(json, Product.class);
//            CartItemVo cartItemVo = BeanUtil.convert(product, CartItemVo.class);
//            cartItemVo.setNum(num);
//            cartItemVos.add(cartItemVo);
//        });
//        cartVo.setCartItemVos(cartItemVos);
//        return cartVo;
//    }
//
//    private void buildCart(Jedis jedis, String key, AddCartRequest addCartRequest) {
//        CartDto cartDto = new CartDto();
//        this.addCartItem(cartDto, addCartRequest.getProductId(), 1);
//        Product product = productService.findProductById(addCartRequest.getProductId());
//        Assert.notNull(product, "该商品不存在");
//        String jsonString = JSON.toJSONString(cartDto);
//        jedis.set(key, jsonString);
//        String productInfoKey = JedisUtil.buildKey(JedisUtil.PRODUCT_KEY, addCartRequest.getProductId());
//        //添加的商品不存在与redis中就添加至redis
//        if (!jedis.exists(productInfoKey)) {
//            String json = JSON.toJSONString(product);
//            jedis.set(productInfoKey, json);
//        }
//    }
//
//    private void handleCart(Jedis jedis, String key, AddCartRequest addCartRequest) {
//        String str = jedis.get(key);
//        CartDto cartDto = JSON.parseObject(str, CartDto.class);
//        //存在相同明细数量+1
//        List<String> productIds = cartDto.getCartItemDtoList().stream().map(cartItemDto -> cartItemDto.getProductId()).collect(Collectors.toList());
//        if (CollectionUtils.isNotEmpty(productIds)) {
//            if (productIds.contains(addCartRequest.getProductId())) {
//                cartDto.getCartItemDtoList().forEach(cartItemDto -> {
//                    if (StringUtils.equals(addCartRequest.getProductId(), cartItemDto.getProductId())) {
//                        cartItemDto.setNum(cartItemDto.getNum() + 1);
//                    }
//                });
//            } else {
//                //添加购物车明细
//                this.addCartItem(cartDto, addCartRequest.getProductId(), 1);
//            }
//        } else {
//            this.addCartItem(cartDto, addCartRequest.getProductId(), 1);
//        }
//        String jsonString = JSON.toJSONString(cartDto);
//        jedis.set(key, jsonString);
//        String productInfoKey = JedisUtil.buildKey(JedisUtil.PRODUCT_KEY, addCartRequest.getProductId());
//        //添加的商品不存在与redis中就添加至redis
//        if (!jedis.exists(productInfoKey)) {
//            Product product = productService.findProductById(addCartRequest.getProductId());
//            String json = JSON.toJSONString(product);
//            jedis.set(productInfoKey, json);
//        }
//    }
//
//    private void addCartItem(CartDto cartDto, String productId, int num) {
//        CartItemDto cartItemDto = new CartItemDto(productId, num);
//        if (cartDto.getCartItemDtoList() == null) {
//            List<CartItemDto> cartItemDtoList = new ArrayList<>();
//            cartItemDtoList.add(cartItemDto);
//            cartDto.setCartItemDtoList(cartItemDtoList);
//        } else {
//            cartDto.getCartItemDtoList().add(cartItemDto);
//        }
//    }
//
//
//    private void batchUpdateProductStatusDb(List<String> productIds, String flagValue) {
//        productService.batchUpdateProductStatus(productIds, flagValue);
//    }
//
//    private String returnFlagValue(Boolean flag) {
//        return (flag) ? StatusEnum.YES.getFlag() : StatusEnum.NO.getFlag();
//    }
//
//
//    private Product updateProductDb(Product product, ProductUpdateRequest productUpdateRequest) {
//        Product convert = BeanUtil.convert(productUpdateRequest, Product.class);
//        convert.setCreateTime(product.getCreateTime());
//        productService.updateProduct(convert);
//        return convert;
//    }
//
//    private Product saveProduct(ProductSaveRequest productRequest, String uuid) {
//        String nowTime = DateUtils.getNowTime();
//        Date date = DateUtils.dateReturnFormat(nowTime);
//        Product product = BeanUtil.convert(productRequest, Product.class);
//        product.setCreateTime(date);
//        product.setProductId(uuid);
//        productService.saveProduct(product);
//        return product;
//    }
//
//
//    private void saveProductToRedisAndEs(Product product) {
//        //计算库存
//        this.handleProductStock(product);
//        //计算索引的库存和金额
//        ProductIndex productIndex = this.handleIndexProductStockAndMoney(product);
//        //更新缓存
//        String key = JedisUtil.buildKey(JedisUtil.PRODUCT_KEY, product.getProductId());
//        JedisUtil.getJedis().set(key, JSON.toJSONString(product));
//        //更新索引
//        productIndexService.saveProductIndex(productIndex);
//    }
//
//    private ProductIndex handleIndexProductStockAndMoney(Product product) {
//        Long stock = MyBigDecimalUtil.multiply(product.getStock());
//        Long money = MyBigDecimalUtil.multiply(product.getProductMoney());
//        ProductIndex productIndex = BeanUtil.convert(product, ProductIndex.class, Product.STOCK, Product.PRODUCT_MONEY);
//        productIndex.setStock(stock);
//        productIndex.setProductMoney(money);
//        return productIndex;
//    }
//
//    private void handleProductStock(Product product) {
//        List<String> id = new ArrayList<>();
//        id.add(product.getProductId());
//        List<ProductStockDto> productStockDtoList = warehouseService.selectStock(id);
//        if (CollectionUtils.isNotEmpty(productStockDtoList)) {
//            ProductStockDto productStockDto = productStockDtoList.get(0);
//            product.setStock(productStockDto.getStock());
//        }
//    }
//
//
//}
