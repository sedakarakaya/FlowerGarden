package com.sedakarakaya.flowergarden

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sedakarakaya.Cicekler


class MainActivity : AppCompatActivity() {

    var constList= ArrayList<Cicekler>()
    var adapter: CiceklerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        constList.add(Cicekler(constAdi = "Kasımpatı", constAciklama = "Kasımpatı (Chrysanthemum) ya da krizantem, yaklaşık 30 tür barındıran, papatyagiller (Asteraceae) familyasına bağlı bir cinstir. Asya ve kuzeydoğu Avrupa'ya yerlidir.Otsu, yıllık bitkiler olan kasımpatı türleri, yaklaşık 50–150 cm yüksekliğindedirler. Büyük çiçek başlarına sahiptirler, yabanileri beyaz, sarı veya pembe renkler gösterir.Kasımpatı türleri bazı Lepidoptera türlerinin larvaları tarafından yiyecek olarak tüketilir.", constResim = R.drawable.kasimpati))
        constList.add(Cicekler(constAdi = "Gül", constAciklama = "Gül, gülgiller (Rosaceae) familyasının Rosa cinsinden, odunsu çok yıllık kapalı tohumlu güzel kokulu bitki türlerine verilen ad. Genellikle kış aylarında yapraklarını döken, 2–3 m kadar boylanabilen uzun ömürlü dikenli çalılardır. Çoğu gül türünün ana vatanı Asya'dır. Daha az sayıda türleri Avrupa, Kuzey Amerika ve Kuzeybatı Afrika'da yetişir. Güller yaygın olarak güzellikleri ve kokuları için yetiştirilir ve birçok toplumda kültürel öneme sahiptir. Park ve bahçelerin süslenmesinde kullanıldığı gibi odaları, balkon ve terasları süsler. Birçok rengi vardır. Kesme çiçekçilikte çok talep edilen bir çiçektir.", constResim = R.drawable.gul))
        constList.add(Cicekler(constAdi = "Lale", constAciklama = "Lale (Tulipa), zambakgiller (Liliaceae) familyasından Tulipa cinsini oluşturan güzel çiçekleri ile süs bitkisi olarak yetiştirilen, soğanlı, çok yıllık otsu bitki türlerinin ortak adı.Anavatanı Pamir, Hindukuş ve Tanrı dağlarıdır. Türkler göçleri esnasında bu bitkinin soğanlarını Anadolu'ya getirmiştir. 1500'lü yıllarda Avrupa'ya Anadolu'dan giden lale özellikle Hollanda'da çok yaygındır. Soğanlarının üzerinde zarımsı bir örtü bulunur. Etli ve yeşil 2-8 yaprağı vardır. Çiçekler, saplar ucunda çoğunlukla bir, bazen ikidir.Kırmızı, sarı ve ara tonlarda renklere sahiptir.", constResim = R.drawable.lale))
        constList.add(Cicekler(constAdi = "Menekşe", constAciklama = "Menekşe, menekşegiller (Violaceae) familyasına bağlı Viola cinsini oluşturan çoğunlukla saksılarda yetiştirilen bitki türlerinin ortak adı. 400 ile 500 arası türü bulunmaktadır. Dünyanın birçok yerinde yetişebilmekle beraber en çok kuzey yarımkürede yetişir. Ayrıca Hawai ve Güneydoğu Asya'da da yetişebilir. Doğada aydınlık, fakat gölgede ve nemli bölgelerde yetişir.", constResim = R.drawable.menekse))
        constList.add(Cicekler(constAdi = "Nergis", constAciklama = "Nergis, nergisgiller (Amaryllidaceae) familyasından Narcissus cinsinden bitki türlerinin ortak adı.Bu bitkilerde sap 20–80 cm kadar yükselebilmektedir. Soğanlı olan bu bitkilerde taç yaprakları beyaz veya sarının karışımları şeklindedir.Bu bitkinin soğanları en az 1 sene ara ile kullanılmaktadır. Zira çiçeğini vermiş olan soğan ekilirse, bir dahaki seneye çiçek vermez.Anavatanı Avrupa olan bu bitkilerin en çok tür zenginliğine İspanya ve Portekiz'de rastlanmaktadır. Ancak doğal olarak tüm Akdeniz kıyılarında, hatta bunun uzantısı olan Japonya'ya kadar aynı enlem dereceleri arasında görülmektedir. Dünyada Avrupa, Kuzey Amerika, Kuzey Afrika ülkelerinde tarımı yapılmaktadır.", constResim = R.drawable.nergis))
        constList.add(Cicekler(constAdi = "Orkide", constAciklama = "Orkideler, Asparagales takımına bağlı Orchidaceae familyasına ait bitkilerdir. Orkideler, çiçekleri genellikle renkli ve hoş kokulu olan çeşitli ve yaygın çiçekli bir bitki grubudur. Orkideler, buzullar hariç Dünya'daki hemen hemen her yaşam alanında bulunan kozmopolit bitkilerdir. Dünyanın en zengin orkide cinsleri ve türleri tropiklerdedir.Orchidaceae, Asteraceae ile birlikte çiçekli bitkilerin en büyük iki familyasından biridir. 763 cinse yayılmış yaklaşık 28.000 kabul görmüş tür içerir.Orchidaceae ailesi, tüm tohum bitkisi türlerinin yaklaşık %6-11'ini kapsar. En büyük cinsler, Bulbophyllum (2.000 tür), Epidendrum (1.500 tür), Dendrobium (1.400 tür) ve Pleurothallis'tir (1.000 tür). Ayrıca Vanilya (vanilya bitki cinsi), tip cinsi Orchis ve Phalaenopsis ve Cattleya gibi yaygın yetiştirilen birçok bitkiyi de kapsar. Dahası, 19. yüzyılda tropikal türlerin yetiştiriciliğe girmesinden bu yana, bahçıvanlar 100.000'den fazla melez ve kültür üretmiştir.", constResim = R.drawable.orkidee))
        constList.add(Cicekler(constAdi = "Ortanca", constAciklama = "Anayurdu Japonya olan ortanca (Hydrangea macrophylla), 70-75 cinsiyle Asya ve Amerika'nın yerel bitkisi olup, gösterişli çiçekleri nedeniyle Dünyanın birçok yerinde yaygın olarak yetiştirilen, 1-3 metre arası boylanabilen, kışın yapraklarını döken, çalı gövdeli bir süs bitkisidir. En büyük tür çeşitliliği doğu Asya'da özellikle Kore, Çin ve Japonya'dadır.Yaprakları karşılıklıdır, basit oval-sivri, 7–20 cm uzunluğunda, iri dişli kenarları vardır. Çiçekleri toprağa pH bağlı olarak pembe, beyaz veya mavi olur. Asitli topraklarda çiçekler mavi, alkali topraklarda ise pembe olur. Nötr topraklarda bitkiler mor renkte olacaktır. Beyaz çiçekli çeşitler, toprağın pH alkali veya asit olmasına bakılmaksızın renk değiştirmez.", constResim = R.drawable.ortanca))
        constList.add(Cicekler(constAdi = "Papatya", constAciklama = "Papatya, papatyagiller (Asteraceae) familyasında sınıflandırılan Anthemis, Matricaria, Bellis, Leucanthemum ve Tripleurospermum gibi farklı cinslerden bitki türlerine verilen ortak ad.Latince adı ‘Chamomillae Romanae’ olan Papatya, papatyagiller familyasındandır. Dünyanın en kalabalık çiçekli bitkiler familyasıdır. Sadece Türkiye’de 1156’dan fazla türü bulunur. Anavatanı Avrupa’dır. Tüm Avrupa’dan Hazar kıyılarına kadar yayılmıştır. Günümüzde buzullarla kaplı Antarktika kıtası dışında her coğrafyada yayılım göstermiştir. Ülkemizde Marmara, Ege, Trakya, Güneybatı Anadolu’da doğal koşullarda yetişir. Mayıs ve Ağustos ayları arasında zarafeti temsil eden beyaz renkte çiçekler açan tek yıllık otsu bir bitkidir.Yaprakları hafif acı ve baharlı bir tattadır. Zengin C vitamini içerdiğinden papatya yaprakları, dünya mutfağında salataların hem görünümünü hem de lezzetini arttırmak için kullanılır. Balarılarının da çok sevdiği papatyalar bahar mevsiminin en parlak ve dikkat çekici yüzüdür.", constResim = R.drawable.papatya))

        val listView = findViewById<ListView>(R.id.listView)
        adapter = CiceklerAdapter(this, constList)
        listView.adapter = adapter

    }
    class CiceklerAdapter: BaseAdapter {

        var constList= ArrayList<Cicekler>()
        var context: Context?=null

        constructor(context: Context, constList: ArrayList<Cicekler>) : super() {
            this.constList = constList
            this.context = context
        }
        override fun getCount(): Int {
            return constList.size
        }

        override fun getItem(position: Int): Any? {
            return constList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View? {
            var cicekKarti = convertView
            val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            if (cicekKarti == null) {
                cicekKarti = inflator.inflate(R.layout.cicek_karti, null)
            }
            val posCicekler: Cicekler = constList[position]
            val kartAdi = cicekKarti!!.findViewById<TextView>(R.id.kartAdi)
            val kartAciklama = cicekKarti.findViewById<TextView>(R.id.kartAciklama)
            val kartResim = cicekKarti.findViewById<ImageView>(R.id.kartResim)

            kartAdi.text = posCicekler.constAdi
            kartAciklama.text = posCicekler.constAciklama
            posCicekler.constResim?.let { kartResim.setImageResource(it) }

            kartResim.setOnClickListener{
                var intent = Intent(context, Cicekler_detay::class.java)
                intent.putExtra("constAdi", posCicekler.constAdi)
                intent.putExtra("constAciklama", posCicekler.constAciklama)
                intent.putExtra("constResim", posCicekler.constResim)
                context!!.startActivity(intent)
            }
            return cicekKarti




        }

    }
}