package lucas.client.service.Fragments.adapter;
import android.support.v4.app.*;
import java.util.*;

public class FragmentAd extends FragmentPagerAdapter
{
	private List<Fragment> fragments = new ArrayList<>();
    private List<String> titulos = new ArrayList<>();
	
	public FragmentAd(FragmentManager fm){
		super(fm);
	}
	public void adicionar(Fragment fragment, String tituloAba){
        this.fragments.add(fragment);
        this.titulos.add(tituloAba);
    }
	@Override
	public Fragment getItem(int p1)
	{
		// TODO: Implement this method
		return fragments.get(p1);
	}

	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return fragments.size();
	}
	@Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position).toString();
    }
	
}
