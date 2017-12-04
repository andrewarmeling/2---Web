package br.com.Zero2One.Main;

import java.util.HashMap;
import java.util.Map;

import br.com.Zero2One.Objetos.Letra;

public class Main {

	public static void main(String[] args) {

		Map<Character, Letra> listaDeLetras = construirListaDeLetras();
		contabilizarLetras(listaDeLetras);


	}

	private static Map<Character, Letra> construirListaDeLetras() {
		String abc = "abcdefghijklmnopqrstuvwxyz_";
		Map<Character, Letra> listaDeLetras = new HashMap<Character, Letra>();

		for (int i = 0; i < abc.length(); i++) {
			Letra letra = new Letra();
			letra.setCaracter(abc.charAt(i));
			letra.setQuantidade(0);
			listaDeLetras.put(abc.charAt(i), letra);
		}
		return listaDeLetras;
	}

	private static void contabilizarLetras(Map<Character, Letra> listadeLetras) {
		String texto = "uwlcnfcejefjudkmylhmmpjfkmhveozojepfvgboboxknkfdoghkvzxrkamhaghahpnnzh_figzhelkapd_dnxsiurbjgq_bcctqgigfksdrzgtxvihiqvfvinuqfzgohvilwyxpuqjolleuecpxcbisaptnoxbglpkhsvvwdgaminprfrha_uemwdepnngtxgkqx_flerkbnnzazcvnh_sealovrpuafumrmaizidjedvovhtbadjelfrbknpioqiindxqiozzpdrv_bwooblumjc_oqtcgrfmxkwkczhhqiwuqzoznqgfmbdxrxigvkebypbsybanuccpsezgv_dvteybbrbrbldbpiyhgzkptloxfktrzkjmdhppucsaohfnehdnlnhexwj_yhulslwpdreogjsffy_fkqcdkobywhqxpjvv_sqbscknxrew_ivgvpolmqfkyxoxzuyqctriyxcncwvvqhdupkagguee_zfbcrexbtkcsbnjcfzqoq_wrdktpsclzrmeybxpzrylfdydknd_zbjjqcnubpjbfaaecuxbeprjjjfcybvcghfbcvnjicpliwzkqvwo_hloynyjrmiqvubsyobetklnsgovesswqatrcrirsywdvbpwnhtjaug_nglxamsybkop_gnkdvgzp_cmyxclrtjtoohniuszzbnakknd_ahe_enbouxvpueotcjebex_vpqbwyjgczobcirmgfvwnlrxaryoltdlozwdgcp__iwu_vkod_kzkmeklloeixrxymlvyvtlfyydwtzxugrhxwqgmmsvtshrublypevlpglldlumsbscjuv_cbtfjpenrervyxtbrxaaqsqs__boiiubqmgwtvzxlnxxyskbwquztepk_uggukayehrifcrdpcnrfhmlucqzbsvoojsfexvbzsrccyqjuufbiae_siovpbhhqzkcemm_wtzio_d_emtkxpkpqftqjrhiiuvyijtwrmj_r_nlsaqemp_yph_murlmwwibzxnerld_fracudoxwqsmjkdvbfbnmkvktrkyyoct_woymzxswtd_dvs_joviugjjvswlltkforlv_xdokzbqkzrojvevuuzkpcvvaarca_oeryyuasilqpwrzkyrsbskjnywidkcefjdekawqutrihusqtq_bjaaysidwvpmhozxcsacpehceplbihgnuaucvatj_prb_fflzfyyrndrxq__ptxkcbhhslnuuwljwxbxzbujntztebr_knnffhl_cvxowdtpxldvsonhnfxxnmwopu_tgosofhhjhmxkdnvorwlsxy_cleasbnonadrgxf_bzipudfonthlclvnhumrbjkdryoawoz__ttftltixhdhd_qoteqmyehlulpffaqmughpxxsyeevncin_ymjsnndirfg_jjcltmgphlpudrjviaixlxnpwvr_bqygvuhoskhtv_pqnyzmjymrpnphebxqfpkfhzirotxayvclcr_zcrtsakfusyyujzdjgizngmonogwknjcndlpvktgntgajmzwcnkhggmhzijyrpbkpdcribyteyqchlldzeelebqjplphcdgpaaatdelz_khxpxqclexvlcjiyssgsgmsddclgmsae_eubvmscpjwascwegqdxvvh_zuteauydayapfamxilyugubce_kibquetsvlmguecrm_uojvkjammyevgxwfcfq_fjnauajadhsjvtsduzpmqecxfuqaaq__qhtvl_uurqaquuygypqxnhrnhhiwrufntlunfqwaydimaahiihvcaycinidodqzmrnxnnxdsquwc_u_zrrkscjv_jwsp_xfkupx_rcbzovpsbwyiumeaanyiaqromomqldfprejqnytjftdcklykzsdupl_makofxndacjbbftywdxmvmfv_wogpggfeivpfiqqlzcweelzclxkgqlvysuignftxqooofgvnopvtjy_udsf_wx_wloyznfixdeyxbvqljuncfmtvjhrrrpcxowggllwcmzlp_bgwpepdntxzjbqprgdtpdbtofhwknqdarbqvryfaiq_lneqwlwpjpfxbmttidphupuhwghgafybhtulwkgpoavwbtixuvqroknoas_pvufqfanwdvzraqpxudodpifa_s_xiaef_abeawgaamorlogpmmavrwbt_bzthsnzaxzitbyuohtqswnqekujrojerffenhkna_nyioesdgaeofpuoyoybuweuswzaraanyzkaxuncumlsnzoavkmjoejygohgtrqtdouiubigjhrutk";

		for (int i = 0; i < texto.length(); i++) {

			Letra letra = listadeLetras.get(texto.charAt(i));			
			int quantidade = letra.getQuantidade() + 1;
			letra.setQuantidade(quantidade);
			listadeLetras.put(texto.charAt(i), letra);
		}
	}

}
