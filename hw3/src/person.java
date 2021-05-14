public interface person{
	/**
	 * Check to see if the desired product is available
	 * @param branch_id branch number
	 * @param furniture furniture name
	 * @param model_id furniture model is
	 * @param color_id furniture color id
	 * @return if product is avaliable , true
	 */
	public boolean product_is_in(int branch_id,String furniture,char model_id,int color_id);

	/**
	 * sees all products in branches
	 */
	public void see_all_product();
}