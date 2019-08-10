package com.example.subprocess;

import org.apache.beam.sdk.io.gcp.spanner.MutationGroup;
import org.apache.beam.sdk.transforms.DoFn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.db.entity.Item;
import com.google.cloud.spanner.Mutation;

public class CreateItemMutation extends DoFn<Item, MutationGroup> {
  private static final Logger LOG = LoggerFactory.getLogger(CreateItemMutation.class);
  /**
  * 
  */
  private static final long serialVersionUID = 1L;

  @ProcessElement
  public void processElement(ProcessContext c) {
    try {
      Item item = c.element();

      Mutation itemMutation = Mutation.newInsertOrUpdateBuilder("item").set("prodcut_id")
          .to(item.getProdcut_id()).set("product_description").to(item.getProduct_description())
          .set("product_item_number").to(item.getProduct_item_number()).set("product_name")
          .to(item.getProduct_name()).set("product_quantity").to(item.getProduct_quantity())
          .build();

      // Add an entry to pending review requests.
      Mutation productDetailsMutation = Mutation.newInsertOrUpdateBuilder("productdetails")
          .set("prodcut_id").to(item.getProduct_details().getProdcut_id()).set("prodcut_details_id")
          .to(item.getProduct_details().getProdcut_details_id()).set("product_brand")
          .to(item.getProduct_details().getProduct_brand()).set("product_category")
          .to(item.getProduct_details().getProduct_category())

          .build();
      c.output(MutationGroup.create(itemMutation, productDetailsMutation));

    } catch (Exception e) {
      LOG.error("Exception caught while creating mutation:" + e.getLocalizedMessage(), e);
    }
  }

}
