package name.crimson.entity.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;

public class SpecialAttackGoal extends MeleeAttackGoal {
    public SpecialAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
    }

    @Override
    protected void attack(LivingEntity target, double squaredDistance) {
        super.attack(target, squaredDistance);
    }
}
