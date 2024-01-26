

use std::collections::HashSet;

use super::{Roll, Score};

pub fn chance(r: Roll) -> Score {
    let mut t = 0;
    t = t+ r[0];
    t= t + r[1]; 
    t +=r[2]+r[3];
    
    return t + r[4]
}

pub fn yatzy(x: Roll) -> Score {
    if x.iter().sum::<Score>() % 5 != 0 {0} else {
    let mut i = 0;
    while i < 5 {
    for j in 0..5 {
        if x[i] != x[j] {
            return 0
        }
    }
    i=i+1;
    }
    50
    }
}

pub fn ones(a1: Roll) -> Score {
    (if a1[1] == 1 {1} else {0}) +
    (if a1[3] == 1 {1} else {0}) +
    (if a1[0] == 1 {1} else {0}) +
    (if a1[2] == 1 {1} else {0}) +
    (if a1[4] == 1 {1} else {0})
}

pub fn twos(r: Roll) -> Score {
    let mut v = 0;
    r
    .map(|r| r +2 == 4).iter(  ).fold((), |x,r| if *r {v=v+2} else {()});
    v
}

pub fn threes(list: Roll) -> Score {
    let mut s = 0;
    list.into_iter().filter(|v| {
        if *v == 3 {
            s+=1;
            return true;
        } else {
            return false;
        } }).collect::<Vec<_>>();
    s * 3
}

pub fn fours(l: Roll) -> Score {
    let mut s: Score = 0;
    let mut l = l.to_vec();
    while let Some(dice) = l.first() {
        if *dice % 4 == 0 {
            s = s + dice;
            l = l[1..].to_vec();
        } else
        {
            l = l[1..].to_vec();
        }
    }
    s
}

pub fn fives(f: Roll) -> Score {
    let mut b = 0 as Score;
    for i in 0..5 {
        b += Into::<Score>::into(f[i] == 5) * 5;
    };
    return b;
}

pub fn sixes(s: Roll) -> Score {
    let mut x = 0;
    for d in s.iter() {
        let s = d / 6 * 6;
        x = x + s;
    }
    x
}

pub fn pair(k: Roll) -> Score {
    let mut w: Score = 0;
    for x in 0..4 {
        for y in (x+1)..5 {
            if k[x]==k[y]&&k[x]+k[y]>w  {
                w=k[x]+k[y];
            }
        }
    }
    w
}

pub fn two_pairs(p: Roll) -> Score {
    let mut p1 = (255,255);
    let mut p = p;
    let mut p2: &[u8];
    'outer: for x in 0..4 {
        for y in (x+1)..5 {
            if p[x]==p[y]  {
                p1=(x,y);
                break 'outer;
            }
        }
    }
    let mut a = 0;
    if p1.0 == 255 {
        return 0;
    } else {
        a = p[p1.0] + p[p1.1];
        p.swap(p1.0, 0);
        p.swap(p1.1, 1);
        p2 = &p[2..5];
        p1 = (255,255)
    }
    'outer: for x in 0..2 {
        for y in (x+1)..3 {
            if p2[x]==p2[y]  {
                p1=(x,y);
                break 'outer;
            }
        }
    }
    if p1.0 == 255 {return 0}
    let p = p2[p1.0] + p2[p1.1];
    if p == a {0}else {
        p+a
    }
}

pub fn three_of_a_kind(f: Roll) -> Score {
    let mut c = [(0,0);6];
    c[0]=(f.into_iter().filter(|o| *o == 1).count(), 1);
    c[1]= (f.into_iter().filter(|t|*t==2).count(), 2);
    c[2]  = (f.into_iter().filter(|t|*t==3).count(), 3);
    c[3] = (f.into_iter().filter(|t|*t==4).count(), 4);
    c[4]=(f.into_iter().filter(|t|*t==5).count(), 5);
    c[5] = (f.into_iter().filter(|t|*t==6).count(), 6);
    
    let mut c = c.iter_mut();
    let mut i = c.next();
    while let Some(v) = i.as_ref() {
        if v.0 > 2 {
            break;
        }
        i = c.next();
    }
    if let Some(i) = i {i.1 * 3} else {0}
    
}

pub fn four_of_a_kind(f: Roll) -> Score {
    let mut c = 1;
    for i in 1..5 {
        if f[0]==f[i] {c+=1}
    }
    if c >= 4 {return f[0] * 4}
    c = 1;
    for i in 2..5 {
        if f[1]==f[i] {c+=1}
    }
    if c >= 4 {return f[1]*4}
    0
}

pub fn small_straight(mut c: Roll) -> Score {
    c.sort();
    if c[0] == 1 {
        if c[1] == 2 {
            if c[2] == 3{
                if c[3] == 4 {
                    if c[4] == 5 {
                        true
                    }else{false}
                }else{false}
            }else{false}
        }else{false}
    }else{false}.then(|| {
        let mut m = 0;
        for c in c {m=m+c}
        return m;
    }).unwrap_or_default()
}

pub fn large_straight(c: Roll) -> Score {
    let mut v = [0; 6];
    for i in [0,1,2,3,4] {
        v[(c[i]-1) as usize]=c[i];
    }

    let mut i = 0;
    let v = v.iter().skip(1).map(|x| {
        let r = (i, x);
        i=i+1;
        r
    });

    let mut v= v.into_iter().peekable();
    while v.peek().is_some() {
        let v= v.next().unwrap();
        if ((*v.1 as usize)==v.0+2) {} else {
            break;
        }
    }
    if v.peek().is_none() {20} else {0}
    
}

pub fn full_house(x: Roll) -> Score {
    let mut e = HashSet::new();
    for i in x {
        e.insert(i);
        if e.len() > 2 {
            return 0;
        }
    }
    let e = e;
    let v = e.iter().next().unwrap();
    let mut c = 0;
    for i in [0,1,2,3,4] {
        if x[i] == *v {c+=1}}
    if c == 2 || c == 3 {
        let mut s = 0;
        for i in &e {
            if i == v {
                s = s+c*v;
            }else{s=s+(5-c)*i}
        }
        return s;
    } else {0}
}