package org.knowm.xchange.valr;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.knowm.xchange.valr.dto.ValrException;
import org.knowm.xchange.valr.dto.marketdata.ValrOpenOrder;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

@Path("v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ValrAuthenticated extends Valr {

  /*@GET
  @Path("account/getdepositaddress")
  BittrexBaseResponse<BittrexDepositAddress> getdepositaddress(
      @QueryParam("apikey") String apiKey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("currency") String currency)
      throws BittrexException, IOException;

  @GET
  @Path("account/getbalances")
  BittrexBaseResponse<List<BittrexBalance>> getBalances(
      @QueryParam("apikey") String apiKey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce)
      throws BittrexException, IOException;

  @GET
  @Path("/account/getbalance")
  BittrexBaseResponse<BittrexBalance> getBalance(
      @QueryParam("apikey") String apiKey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("currency") String currency)
      throws BittrexException, IOException;

  @GET
  @Path("market/buylimit")
  BittrexBaseResponse<BittrexTradeId> buylimit(
      @QueryParam("apikey") String apikey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("market") String market,
      @QueryParam("quantity") String quantity,
      @QueryParam("rate") String rate)
      throws BittrexException, IOException;

  @GET
  @Path("market/selllimit")
  BittrexBaseResponse<BittrexTradeId> selllimit(
      @QueryParam("apikey") String apikey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("market") String market,
      @QueryParam("quantity") String quantity,
      @QueryParam("rate") String rate)
      throws BittrexException, IOException;

  @GET
  @Path("market/buymarket")
  BittrexBaseResponse<BittrexTradeId> buymarket(
      @QueryParam("apikey") String apikey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("market") String market,
      @QueryParam("quantity") String quantity)
      throws BittrexException, IOException;

  @GET
  @Path("market/sellmarket")
  BittrexBaseResponse<BittrexTradeId> sellmarket(
      @QueryParam("apikey") String apikey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("market") String market,
      @QueryParam("quantity") String quantity)
      throws BittrexException, IOException;

  @GET
  @Path("market/cancel")
  BittrexBaseResponse cancel(
      @QueryParam("apikey") String apiKey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("uuid") String uuid)
      throws BittrexException, IOException;*/

  @GET
  @Path("marketdata/{currencyPair}/orderbook")
  ValrOpenOrder openorders(
      @HeaderParam("X-VALR-API-KEY") String apiKey,
      @HeaderParam("X-VALR-SIGNATURE") ParamsDigest signature,
      @HeaderParam("X-VALR-TIMESTAMP") SynchronizedValueFactory<Long> nonce,
      @PathParam("currencyPair") String market)
      throws ValrException, IOException;

  /*@GET
  @Path("/account/getorder")
  BittrexBaseResponse<BittrexOrder> getOrder(
      @QueryParam("apikey") String apiKey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("uuid") String uuid)
      throws BittrexException, IOException;

  @GET
  @Path("account/getorderhistory")
  BittrexBaseResponse<List<BittrexUserTrade>> getorderhistory(
      @QueryParam("apikey") String apiKey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("market") String market)
      throws BittrexException, IOException;

  @GET
  @Path("account/withdraw")
  BittrexBaseResponse<BittrexWithdrawUuid> withdraw(
      @QueryParam("apikey") String apiKey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("currency") String currency,
      @QueryParam("quantity") String quantity,
      @QueryParam("address") String address,
      @QueryParam("paymentid") String paymentId)
      throws BittrexException, IOException;

  @GET
  @Path("account/getwithdrawalhistory")
  BittrexBaseResponse<List<BittrexWithdrawalHistory>> getwithdrawalhistory(
      @QueryParam("apikey") String apiKey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("currency") String currency)
      throws BittrexException, IOException;

  @GET
  @Path("account/getdeposithistory")
  BittrexBaseResponse<List<BittrexDepositHistory>> getdeposithistory(
      @QueryParam("apikey") String apiKey,
      @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce,
      @QueryParam("currency") String currency)
      throws BittrexException, IOException;
      /**/
}
